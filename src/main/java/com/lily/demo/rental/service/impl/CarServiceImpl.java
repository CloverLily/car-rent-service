package com.lily.demo.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lily.demo.rental.dao.CarDAO;
import com.lily.demo.rental.model.bo.CarBO;
import com.lily.demo.rental.model.entity.CarDO;
import com.lily.demo.rental.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author lily
 * @description 汽车信息表DAO服务实现类
 * @Date 2022/7/25
 */
@Slf4j
@Service
public class CarServiceImpl extends ServiceImpl<CarDAO, CarDO> implements CarService {

    @Resource
    private CarDAO carDAO;

    @Override
    public List<CarDO> searchAvailableCar() {
        LambdaQueryWrapper<CarDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(CarDO::getAmount, 0);

        return carDAO.selectList(queryWrapper);
    }

    @Override
    public CarDO getById(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }

        return carDAO.selectById(id);
    }

    @Override
    public boolean updateByCriteria(CarBO carBO) {
        if (Objects.isNull(carBO) || Objects.isNull(carBO.getId()) || Objects.isNull(carBO.getOldLockVersion())) {
            return false;
        }

        LambdaUpdateWrapper<CarDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(CarDO::getId, carBO.getId())
                .eq(CarDO::getLockVersion, carBO.getOldLockVersion())
                .eq(CarDO::getAmount, carBO.getOldAmount());
        updateWrapper.set(CarDO::getAmount, carBO.getNewAmount())
                .set(CarDO::getLockVersion, carBO.getOldLockVersion() + 1)
                .set(CarDO::getUpdateTime, new Date());

        return carDAO.update(null, updateWrapper) > 0;
    }


}