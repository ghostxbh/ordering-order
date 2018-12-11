package club.aiit.order.dao;

import club.aiit.order.OrderApplicationTests;
import club.aiit.order.enums.OrderStatusEnum;
import club.aiit.order.enums.PayStatusEnum;
import club.aiit.order.model.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 14:31
 */
@Component
public class OrderMasterMapperTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Test
    public void save() {
        OrderMaster o = new OrderMaster();
        o.setName("李四");
        o.setPhone("13389817374");
        o.setAddress("北京市海淀区万寿路8号");
        o.setAmount(32.00);
        o.setCreateTime(new Date());
        o.setUpdateTime(new Date());
        o.setOrderStatus(OrderStatusEnum.NEW.getCode());
        o.setPayStatus(PayStatusEnum.WAIT.getCode());
        o.setOpenid("fghdfhdf4564fgs54df56sd1g4");
        OrderMaster save = orderMasterMapper.save(o);
        Assert.assertTrue(save != null);
    }

}