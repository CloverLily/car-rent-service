package com.lily.demo.rental;

import com.lily.demo.rental.common.enums.ResultMessageEnum;
import com.lily.demo.rental.controller.CarRentalController;
import com.lily.demo.rental.model.entity.CarDO;
import com.lily.demo.rental.model.vo.OrderRequest;
import com.lily.demo.rental.model.vo.RentalResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import javax.annotation.Resource;

/**
 * 租赁汽车服务接口测试类
 */
@SpringBootTest
class CarRentalControllerTest {

    @Resource
    private CarRentalController carRentalController;

    @Test
    void searchAvailableCar() {
        RentalResult<CarDO> rentalResult = carRentalController.searchAvailableCar();
        AssertionErrors.assertEquals("查询可租用汽车 失败", RentalResult.SUCCESS_CODE, rentalResult.getCode());
    }

    @Test
    void orderCar() {

        //正常租赁流程
        OrderRequest orderRequestNormal = new OrderRequest();
        orderRequestNormal.setCarId(1L);
        orderRequestNormal.setRentAmount(1);
        orderRequestNormal.setUserId(2L);
        RentalResult<String> normalRentalResult = carRentalController.orderCar(orderRequestNormal);
        AssertionErrors.assertEquals("正常租赁流程失败", RentalResult.SUCCESS_CODE, normalRentalResult.getCode());

        //异常租赁流程-租赁数量 < 1
        OrderRequest orderRequestAbnormal_1 = new OrderRequest();
        orderRequestAbnormal_1.setCarId(1L);
        orderRequestAbnormal_1.setRentAmount(-1);
        orderRequestAbnormal_1.setUserId(2L);
        RentalResult<String> abnormalRentalResult1 = carRentalController.orderCar(orderRequestAbnormal_1);
        AssertionErrors.assertEquals("异常租赁流程-租赁数量＜１失败",
                ResultMessageEnum.MIN_AMOUNT_INVALID.getDesc() + 1, abnormalRentalResult1.getMessage());

        //异常租赁流程-租赁数量 > 可租赁数量
        OrderRequest orderRequestAbnormal_2 = new OrderRequest();
        orderRequestAbnormal_2.setCarId(1L);
        orderRequestAbnormal_2.setRentAmount(10000);
        orderRequestAbnormal_2.setUserId(2L);
        RentalResult<String> abnormalRentalResult2 = carRentalController.orderCar(orderRequestAbnormal_2);
        AssertionErrors.assertEquals("异常租赁流程-租赁数量 >可租赁数量 失败",
                ResultMessageEnum.RENT_AMOUNT_INVALID.getDesc(), abnormalRentalResult2.getMessage());

        //异常租赁流程-租赁汽车不存在
        OrderRequest orderRequestAbnormal_3 = new OrderRequest();
        orderRequestAbnormal_3.setCarId(0L);
        orderRequestAbnormal_3.setRentAmount(1);
        orderRequestAbnormal_3.setUserId(2L);
        RentalResult<String> abnormalRentalResult3 = carRentalController.orderCar(orderRequestAbnormal_3);
        AssertionErrors.assertEquals("异常租赁流程-租赁汽车不存在 失败",
                ResultMessageEnum.INVALID_CAR.getDesc(), abnormalRentalResult3.getMessage());
    }
}
