package com.bssm.memodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class MemodevApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemodevApplication.class, args);
	}

}
