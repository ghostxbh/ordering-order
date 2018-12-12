package club.aiit.order.service.impl;

import club.aiit.order.client.ProductClient;
import club.aiit.order.dao.OrderDetailMapper;
import club.aiit.order.dao.OrderMasterMapper;
import club.aiit.order.dto.CartDTO;
import club.aiit.order.dto.OrderDTO;
import club.aiit.order.enums.OrderStatusEnum;
import club.aiit.order.enums.PayStatusEnum;
import club.aiit.order.model.OrderDetail;
import club.aiit.order.model.OrderMaster;
import club.aiit.order.model.Product;
import club.aiit.order.service.OrderService;
import club.aiit.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 15:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String code = KeyUtil.getUniqueKey();
        //查询商品信息（调用商品服务）
        List<Integer> productIdList = orderDTO.getDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<Product> productList = productClient.listForOrder(productIdList);
        //计算总价(保留2为小数)
        DecimalFormat df = new DecimalFormat("#.##");
        Double amount = null;
        for (OrderDetail orderDetail : orderDTO.getDetailList()) {
            for (Product product : productList) {
                if (orderDetail.getProductId().equals(product.getId())) {
                    //单价*数量
                    amount += product.getPrice() * orderDetail.getProductQuantity();
                    BeanUtils.copyProperties(product, orderDetail);
                    //订单详情入库
                    orderDetailMapper.save(orderDetail);
                }
            }
        }
        //扣库存（调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getDetailList().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setCode(KeyUtil.getUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setAmount(Double.valueOf(amount));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.save(orderMaster);
        return orderDTO;
    }
}
