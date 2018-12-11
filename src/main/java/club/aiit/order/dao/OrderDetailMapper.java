package club.aiit.order.dao;

import club.aiit.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 14:26
 */
public interface OrderDetailMapper extends JpaRepository<OrderDetail,Integer>{

}
