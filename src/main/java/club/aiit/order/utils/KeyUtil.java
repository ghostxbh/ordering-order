package club.aiit.order.utils;

import java.util.Random;

/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 15:08
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 时间戳+随机数
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        int nuber = random.nextInt(90000) + 100000;
        return System.currentTimeMillis() + String.valueOf(nuber);
    }
}
