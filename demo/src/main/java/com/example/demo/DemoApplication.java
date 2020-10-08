package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class DemoApplication {
	
	
	private String ttt = "tttt";
	private String add = "tttt1";
	
	@RequestMapping("/")
	 public String home() {
	  return xxx();
	 }

	@RequestMapping("/index")
	 public String index() {
	  return "Hello Spring Boot index";
	 }
	
	public String xxx() {
		return "xxx";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
