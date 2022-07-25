package com.lily.demo.rental.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lily.demo.rental.model.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author lily
 * @description 用户表DAO
 * @Date 2022/7/25
 */
@Repository
public interface UserDAO extends BaseMapper<UserDO> {

}
