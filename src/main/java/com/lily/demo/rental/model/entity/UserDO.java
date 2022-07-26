package com.lily.demo.rental.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * @author lily
 * @description 用户表
 * @Date 2022/7/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("USER")
public class UserDO extends Model<UserDO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 版本号
     * 用于乐观锁
     */
    private Integer lockVersion;
    /**
     * 备注
     */
    private String reMark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
