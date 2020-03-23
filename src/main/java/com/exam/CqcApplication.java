package com.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true) //开启事务支持,然后在访问数据库的Service方法上添加注解@Transactional便可
@MapperScan("com.exam.dao")
public class CqcApplication {
    public static void main(String[] args) {
        SpringApplication.run(CqcApplication.class, args);
    }

}
