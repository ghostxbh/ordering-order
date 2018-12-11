package club.aiit.order.service.impl;

import club.aiit.order.dao.OrderDetailMapper;
import club.aiit.order.dao.OrderMasterMapper;
import club.aiit.order.dto.OrderDTO;
import club.aiit.order.enums.OrderStatusEnum;
import club.aiit.order.enums.PayStatusEnum;
import club.aiit.order.model.OrderMaster;
import club.aiit.order.service.OrderService;
import club.aiit.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public OrderDTO reate(OrderDTO orderDTO) {
        //TODO 查询商品信息（调用商品服务）
        //TODO 计算总价
        //TODO 扣库存（调用商品服务）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setCode(KeyUtil.getUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setAmount(50.00);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster save = orderMasterMapper.save(orderMaster);
        return null;
    }
}
