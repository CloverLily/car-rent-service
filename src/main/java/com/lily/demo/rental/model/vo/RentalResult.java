package com.lily.demo.rental.model.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lily
 * @description 租赁服务返回值
 * @Date 2022/7/25
 */
@Data
public class RentalResult<T extends Serializable> implements Serializable {


    /**
     * 成功码
     */
    public static final String SUCCESS_CODE = "200";
    /**
     * 默认失败码
     */
    public static final String DEFAULT_FAIL_CODE = "-1";
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回提示信息
     */
    private String message;
    /**
     * 返回数据列表
     */
    private List<T> dataList;

    /**
     * 默认成功返回
     *
     * @return 成功结果
     */
    public static <T extends Serializable> RentalResult<T> success(String message, List<T> dataList) {
        RentalResult<T> rentalResult = new RentalResult<>();
        rentalResult.setCode(SUCCESS_CODE);
        rentalResult.setMessage(message);
        rentalResult.setDataList(dataList);
        return rentalResult;
    }

    /**
     * 默认成功返回
     *
     * @return 成功结果
     */
    public static <T extends Serializable> RentalResult<T> success(String message) {
        RentalResult<T> rentalResult = new RentalResult<>();
        rentalResult.setCode(SUCCESS_CODE);
        rentalResult.setMessage(message);
        return rentalResult;
    }

    /**
     * 默认返回单个失败
     *
     * @param message 错误信息
     * @return 失败返回
     */
    public static <T extends Serializable> RentalResult<T> fail(String message) {
        RentalResult<T> rentalResult = new RentalResult<>();
        rentalResult.setCode(DEFAULT_FAIL_CODE);
        rentalResult.setMessage(message);
        return rentalResult;
    }


}
