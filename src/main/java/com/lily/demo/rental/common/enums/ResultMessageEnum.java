package com.lily.demo.rental.common.enums;

import lombok.Getter;

/**
 * 返回信息枚举
 *
 * @author lily
 * @date 2022/7/25
 */
public enum ResultMessageEnum {

    /**
     * 接口请求成功
     */
    REQUEST_SUCCESS("请求成功"),
    /**
     * 接口请求失败
     */
    REQUEST_FAIL("请求失败，请稍后重试"),
    /**
     * 查询汽车信息返回空
     */
    INVALID_CAR("不存在汽车信息"),
    /**
     * 租赁数量小于最小租赁数量
     */
    MIN_AMOUNT_INVALID("租赁数量不能小于"),
    /**
     * 租赁数量大于可租赁数量
     */
    RENT_AMOUNT_INVALID("租赁数量不能大于目前可租赁数量"),
    ;

    @Getter
    private String desc;

    ResultMessageEnum(String desc) {
        this.desc = desc;
    }

}
