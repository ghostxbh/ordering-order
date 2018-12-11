package club.aiit.order.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @Author: ghostxbh
 * @Date: 11/12/2018 11:34
 */
@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String meg;

    /**
     * 具体内容
     */
    private T date;

    /**
     * 数据构建
     * @param code
     * @param meg
     * @param date
     */
    public ResultVo(Integer code, String meg, T date) {
        this.code = code;
        this.meg = meg;
        this.date = date;
    }
}
