package com.lily.demo.rental.model.bo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lily
 * @description 汽车信息表更新BO
 * @Date 2022/7/25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 更新前数量
     */
    private Integer oldAmount;
    /**
     * 更新后数量
     */
    private Integer newAmount;
    /**
     * 更新前版本号
     */
    private Integer oldLockVersion;
    /**
     * 备注
     */
    private String remark;
    /**
     * 更新时间
     */
    private Date updateTime;


}
