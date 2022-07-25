package com.lily.demo.rental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lily.demo.rental.model.entity.CarDO;
import org.springframework.stereotype.Repository;

/**
 * @author lily
 * @description 汽车信息表DAO
 * @Date 2022/7/25
 */
@Repository
public interface CarDAO extends BaseMapper<CarDO> {

}
