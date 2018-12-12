package club.aiit.order.dto;

import lombok.Data;

/**
 * @Author: ghostxbh
 * @Date: 12/12/2018 11:12
 */
@Data
public class CartDTO {

    private Integer productId;

    private Integer productQuantity;

    public CartDTO(Integer productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
    public CartDTO(){}
}
