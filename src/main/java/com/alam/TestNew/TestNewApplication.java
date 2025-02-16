package com.alam.TestNew;

import com.alam.TestNew.configuration.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestNewApplication implements CommandLineRunner {

	@Autowired
	DB db;
	public static void main(String[] args) {
		SpringApplication.run(TestNewApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		System.out.println(db.getData());
	}

}
