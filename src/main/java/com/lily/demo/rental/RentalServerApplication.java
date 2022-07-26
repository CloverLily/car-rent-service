package com.lily.demo.rental;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lily
 * @description 汽车租赁服务启动类
 * @Date 2022/07/25
 */
@EnableTransactionManagement
@MapperScan(value = {"com.lily.demo.rental.dao"})
@SpringBootApplication
public class RentalServerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RentalServerApplication.class);
        app.run(args);
    }

}
