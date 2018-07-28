package com.beannote.beannote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.beannote.beannote.user.dao")
public class BeanNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanNoteApplication.class, args);
    }
}
