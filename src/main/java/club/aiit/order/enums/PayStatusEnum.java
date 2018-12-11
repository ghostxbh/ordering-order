package club.aiit.order.enums;

import lombok.Getter;

/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 14:49
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
