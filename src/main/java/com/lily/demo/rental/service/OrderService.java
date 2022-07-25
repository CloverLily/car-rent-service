package com.lily.demo.rental.service;

import com.lily.demo.rental.model.vo.OrderRequest;

/**
 * @author lily
 * @description 汽车租赁订单表服务
 * @Date 2022/7/25
 */
public interface OrderService {

    /**
     * 租赁汽车
     * @param request 租赁参数
     * @return 租赁结果
     */
    boolean orderCar(OrderRequest request);

}
