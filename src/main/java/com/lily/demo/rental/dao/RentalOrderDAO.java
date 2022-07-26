package com.lily.demo.rental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lily.demo.rental.model.entity.RentalOrderDO;
import org.springframework.stereotype.Repository;

/**
 * @author lily
 * @description 租赁订单表DAO
 * @Date 2022/7/25
 */
@Repository
public interface RentalOrderDAO extends BaseMapper<RentalOrderDO> {

}