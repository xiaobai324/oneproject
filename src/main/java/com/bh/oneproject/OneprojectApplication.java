package com.bh.oneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//在 springBoot 启动会自动扫描@WebServlet，将该类实例化
@ServletComponentScan
public class OneprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneprojectApplication.class, args);
    }

}
