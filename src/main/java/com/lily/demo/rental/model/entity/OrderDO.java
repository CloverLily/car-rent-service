package com.lily.demo.rental.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * @author lily
 * @description 租赁订单表
 * @Date 2022/7/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("ORDER")
public class OrderDO extends Model<OrderDO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单唯一流水号
     */
    private String applyId;
    /**
     * 汽车id
     *
     * @see CarDO#getId()
     */
    private Long carId;
    /**
     * 汽车名称
     */
    private String carName;
    /**
     * 租赁数量
     */
    private Integer rentAmount;
    /**
     * 汽车id
     *
     * @see CarDO#getId()
     */
    private Long userId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}