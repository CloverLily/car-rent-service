package com.lily.demo.rental.controller;

import com.alibaba.fastjson.JSON;
import com.lily.demo.rental.common.enums.ResultMessageEnum;
import com.lily.demo.rental.model.entity.CarDO;
import com.lily.demo.rental.model.vo.OrderRequest;
import com.lily.demo.rental.model.vo.RentalResult;
import com.lily.demo.rental.service.CarRentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
 * @author lily
 * @description 汽车租赁服务请求接口
 * @Date 2022/7/25
 */
@Slf4j
@RestController
@RequestMapping("/car/rental/")
public class CarRentalController {

    @Resource
    private CarRentalService carRentalService;

    /**
     * 根据运单号批量查询计费重量相关信息
     *
     * @return 运单重量信息
     */
    @GetMapping("/info")
    public RentalResult<CarDO> searchAvailableCar() {
        try {
            return carRentalService.searchAvailableCar();
        } catch (Exception e) {
            log.error("查询可租赁汽车异常,", e);
            return RentalResult.fail(ResultMessageEnum.REQUEST_FAIL.getDesc());
        }
    }

    /**
     * 租赁汽车
     *
     * @param request 租赁参数
     * @return 租赁结果
     */
    @PostMapping("/order")
    public RentalResult<String> orderCar(@RequestBody OrderRequest request) {
        try {
            return carRentalService.orderCar(request);
        } catch (Exception e) {
            log.error("租赁汽车异常, 入参:{}", JSON.toJSONString(request), e);
            return RentalResult.fail(ResultMessageEnum.REQUEST_FAIL.getDesc());
        }
    }

}
