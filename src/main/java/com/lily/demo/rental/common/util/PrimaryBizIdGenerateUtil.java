package com.lily.demo.rental.common.util;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * @author lily
 * @description 唯一流水号生成工具
 * @Date 2022/7/25
 */
public class PrimaryBizIdGenerateUtil {

    private PrimaryBizIdGenerateUtil() {
    }

    /**
     * 生成唯一流水号
     *
     * @return prefix+时间戳+5位随机数
     */
    public static String getFlowId(String prefix) {
        //5位随机数
        Random rand = new SecureRandom();
        int random = rand.nextInt(90000) + 10000;
        return prefix + DateUtil.dateToString(new Date(), DateUtil.DATE_PATTERN_Y4M2D2H2M2S2S3) + random;
    }

}