package com.lily.demo.rental.service;

import com.lily.demo.rental.model.bo.CarBO;
import com.lily.demo.rental.model.entity.CarDO;

import java.util.List;

/**
 * @author lily
 * @description 汽车信息表DAO服务
 * @Date 2022/7/25
 */
public interface CarService {

    /**
     * 查询可租赁的汽车
     * @return 可租赁汽车列表
     */
    List<CarDO> searchAvailableCar();


    /**
     * 根据id查询汽车信息
     * @param id 汽车信息表id
     * @return 汽车信息
     */
    CarDO getById(Long id);

    /**
     * 根据条件更新汽车信息
     * @param carBO 汽车信息DO
     * @return 更新结果
     */
    boolean updateByCriteria(CarBO carBO);



}