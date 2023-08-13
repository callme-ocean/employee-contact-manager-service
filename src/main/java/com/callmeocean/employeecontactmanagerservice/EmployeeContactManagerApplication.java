package com.callmeocean.employeecontactmanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan(basePackages = "com.callmeocean.employeecontactmanagerservice.repositories")
@SpringBootApplication
public class EmployeeContactManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeContactManagerApplication.class, args);
    }

}
