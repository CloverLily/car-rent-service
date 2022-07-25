package com.lily.demo.rental.service.impl;

import com.lily.demo.rental.common.enums.ResultMessageEnum;
import com.lily.demo.rental.model.bo.CarBO;
import com.lily.demo.rental.model.entity.CarDO;
import com.lily.demo.rental.model.vo.OrderRequest;
import com.lily.demo.rental.model.vo.RentalResult;
import com.lily.demo.rental.service.CarRentalService;
import com.lily.demo.rental.service.CarService;
import com.lily.demo.rental.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author lily
 * @description 汽车租赁服务实现类
 * @Date 2022/7/25
 */
@Slf4j
@Service
public class CarRentalServiceImpl implements CarRentalService {

    @Resource
    private CarService carService;
    @Resource
    private OrderService orderService;

    @Override
    public RentalResult<CarDO> searchAvailableCar() {
        List<CarDO> availableCarList = carService.searchAvailableCar();
        return RentalResult.success("请求成功", availableCarList);
    }

    @Override
    public RentalResult<String> orderCar(OrderRequest request) {

        CarDO carDO = carService.getById(request.getCarId());

        RentalResult<String> verifyResult = verifyOrderRequest(request, carDO);
        if (Objects.nonNull(verifyResult)) {
            return verifyResult;
        }

        if (!carService.updateByCriteria(buildCarBO(request, carDO))) {
            return RentalResult.fail(ResultMessageEnum.REQUEST_FAIL.getDesc());
        }

        if (Objects.nonNull(carDO)) {
            request.setCarName(carDO.getName());
        }
        if (orderService.orderCar(request)) {
            return RentalResult.success(ResultMessageEnum.REQUEST_SUCCESS.getDesc());
        }

        return RentalResult.fail(ResultMessageEnum.REQUEST_FAIL.getDesc());
    }

    /**
     * 校验入参合法性
     *
     * @param request 请求参数
     * @param carDO   租赁汽车历史信息
     * @return 校验结果
     */
    private RentalResult<String> verifyOrderRequest(OrderRequest request, CarDO carDO) {

        if (Objects.isNull(carDO)) {
            return RentalResult.fail(ResultMessageEnum.INVALID_CAR.getDesc());
        }

        //最小租赁数量
        int minRentAmount = 1;
        if (request.getRentAmount() < minRentAmount) {
            return RentalResult.fail(ResultMessageEnum.MIN_AMOUNT_INVALID.getDesc() + minRentAmount);
        }

        if (request.getRentAmount() > carDO.getAmount()) {
            return RentalResult.fail(ResultMessageEnum.RENT_AMOUNT_INVALID.getDesc());
        }

        return null;
    }

    /**
     * 构建汽车更新信息BO
     *
     * @param request 请求参数
     * @param carDO   租赁汽车历史信息
     * @return 汽车更新信息BO
     */
    private CarBO buildCarBO(OrderRequest request, CarDO carDO) {
        if (Objects.isNull(request) || Objects.isNull(carDO)) {
            return null;
        }

        return CarBO.builder()
                .id(carDO.getId())
                .oldAmount(carDO.getAmount())
                .newAmount(carDO.getAmount() - request.getRentAmount())
                .oldLockVersion(carDO.getLockVersion())
                .build();
    }
}
