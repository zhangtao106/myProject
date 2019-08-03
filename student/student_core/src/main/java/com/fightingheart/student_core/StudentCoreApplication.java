package com.fightingheart.student_core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fightingheart.student_core.*.dao")
public class StudentCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCoreApplication.class, args);
    }

}
