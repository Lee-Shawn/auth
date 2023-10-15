package com.laughing.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: laughing
 * @Create: 2023/10/14 20:10
 * @Description:
 * @Version: 1.0
 */
@MapperScan("com.laughing.system.mapper")
@SpringBootApplication
public class AuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityApplication.class, args);
    }
}
