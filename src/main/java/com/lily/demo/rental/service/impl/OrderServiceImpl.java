package com.lily.demo.rental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lily.demo.rental.common.util.PrimaryBizIdGenerateUtil;
import com.lily.demo.rental.dao.OrderDAO;
import com.lily.demo.rental.model.entity.OrderDO;
import com.lily.demo.rental.model.vo.OrderRequest;
import com.lily.demo.rental.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author lily
 * @description 租赁订单服务实现类
 * @Date 2022/7/25
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDAO, OrderDO>
        implements OrderService {

    @Resource
    private OrderDAO orderDAO;

    /**
     * 租赁订单流水号前缀
     */
    private static final String RENTAL_PREFIX = "RT";


    @Override
    public boolean orderCar(OrderRequest request) {
        if (Objects.isNull(request) || Objects.isNull(request.getCarId())
                || Objects.isNull(request.getRentAmount()) || Objects.isNull(request.getUserId())) {
            return false;
        }

        OrderDO model = buildOrderDO(request);
        return orderDAO.insert(model) > 0;
    }

    private OrderDO buildOrderDO(OrderRequest request) {
        Date now = new Date();
        OrderDO orderDO = OrderDO.builder()
                .carId(request.getCarId())
                .carName(request.getCarName())
                .rentAmount(request.getRentAmount())
                .userId(request.getUserId())
                .createTime(now)
                .updateTime(now)
                .build();

        orderDO.setApplyId(PrimaryBizIdGenerateUtil.getFlowId(RENTAL_PREFIX));

        return orderDO;
    }
}