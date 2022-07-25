package com.lily.demo.rental.service;


import com.lily.demo.rental.model.entity.CarDO;
import com.lily.demo.rental.model.vo.OrderRequest;
import com.lily.demo.rental.model.vo.RentalResult;

/**
 * @description 汽车租赁服务
 * @author lily
 * @Date 2022/7/25
 */
public interface CarRentalService {

    /**
     * 根据运单号批量查询计费重量相关信息
     * @return 运单重量信息
     */
    RentalResult<CarDO> searchAvailableCar();

    /**
     * 租赁汽车
     * @param request 租赁参数
     * @return 租赁结果
     */
    RentalResult<String> orderCar(OrderRequest request);

}
