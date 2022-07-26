package com.lily.demo.rental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lily.demo.rental.common.util.PrimaryBizIdGenerateUtil;
import com.lily.demo.rental.dao.RentalOrderDAO;
import com.lily.demo.rental.model.entity.RentalOrderDO;
import com.lily.demo.rental.model.vo.OrderRequest;
import com.lily.demo.rental.service.RentalOrderService;
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
public class RentalOrderServiceImpl extends ServiceImpl<RentalOrderDAO, RentalOrderDO>
        implements RentalOrderService {

    @Resource
    private RentalOrderDAO orderDAO;

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

        RentalOrderDO model = buildOrderDO(request);
        return orderDAO.insert(model) > 0;
    }

    private RentalOrderDO buildOrderDO(OrderRequest request) {
        Date now = new Date();
        RentalOrderDO orderDO = RentalOrderDO.builder()
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