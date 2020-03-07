package com.liutong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestBeetlSqlApplication {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(SpringBootTestBeetlSqlApplication.class);
        SpringApplication.run(SpringBootTestBeetlSqlApplication.class);
        log.info("启动成功");
    }
}
