package com.lily.demo.rental.model.vo;


import com.lily.demo.rental.model.entity.CarDO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lily
 * @description 租赁汽车请求参数
 * @Date 2022/7/25
 */
@Data
public class OrderRequest implements Serializable {

    /**
     * 汽车id
     *
     * @see CarDO#getId()
     */
    @NotNull(message = "汽车信息不能为空")
    private Long carId;
    /**
     * 汽车名称
     */
    private String carName;
    /**
     * 租赁数量
     */
    @NotNull(message = "租赁数量不能为空")
    private Integer rentAmount;
    /**
     * 汽车id
     *
     * @see CarDO#getId()
     */
    @NotNull(message = "用户信息不能为空")
    private Long userId;

}