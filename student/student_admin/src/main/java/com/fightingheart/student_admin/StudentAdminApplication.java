package com.fightingheart.student_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fightingheart.student_core.*.dao")
public class StudentAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAdminApplication.class, args);
    }

}
