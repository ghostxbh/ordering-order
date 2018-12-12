package club.aiit.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author xu
 * @DateTime 2018-12-11 10:00
 */


@Data
//@Table(name="y_xxx")
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Double price;

    private Integer stock;//库存

    private String description;//描述

    private String icon;//小图

    private Integer status;

    private Integer category;

    private Date createTime;

    private Date updateTime;


}
