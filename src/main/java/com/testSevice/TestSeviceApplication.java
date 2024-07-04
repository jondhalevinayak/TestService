package com.testSevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class TestSeviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestSeviceApplication.class, args);
        Object dataSource = context.getBean("dataSource");
        System.out.println("Datasource is::" + dataSource);
    }
}
