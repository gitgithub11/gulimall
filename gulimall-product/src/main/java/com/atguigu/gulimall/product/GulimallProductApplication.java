package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
* 1.整合Mybatis-Plus
*   1)导入依赖 common
*   2)配置
*       1.配置数据源
*           1)导入数据库驱动 common里
*           2）在application.yml配置数据源
*       2.配置Mybatis-Plus
*           1)使用@MapperScan
*           2）application.yml中指定SQL映射文件位置
* */

//告诉mabatis-plus 接口位置
@MapperScan("com.atguigu.gulimall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
