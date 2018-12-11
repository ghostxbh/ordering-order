package club.aiit.order.dao;

import club.aiit.order.OrderApplicationTests;
import club.aiit.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 14:29
 */
@Component
public class OrderDetailMapperTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void sava() {
        OrderDetail o = new OrderDetail();
        o.setOrderId(1);
        o.setProductId(2);
        o.setProductName("木须肉盖饭");
        o.setProductPrice(22.00);
        o.setProductQuantity(1);
        o.setCreateTime(new Date());
        o.setUpdateTime(new Date());
        OrderDetail save = orderDetailMapper.save(o);
        Assert.assertTrue(save != null);
    }

}