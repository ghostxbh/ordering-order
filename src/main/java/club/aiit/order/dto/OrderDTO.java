package club.aiit.order.dto;

import club.aiit.order.model.OrderDetail;
import lombok.Data;

import java.util.List;

/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 14:57
 */
@Data
public class OrderDTO {

    private String code;

    private String name;

    private String phone;

    private String address;

    private String openid;

    private Double amount;

    private Integer orderStatus;

    private Integer payStatus;

    private List<OrderDetail> detailList;
}
