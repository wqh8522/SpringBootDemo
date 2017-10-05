package com.wqh.springbootmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author wqh
 * @Date 2017/10/03 16:44
 * @Description:
 * */
@SpringBootApplication
//@MapperScan("com.wqh.springbootmybatis.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
