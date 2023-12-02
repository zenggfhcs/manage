package com.lib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {/*"com.lib.error", */"com.lib.aop", "com.lib.dao", "com.lib.service", "com.lib.web"})
public class WebApplication {
public static void main(String[] args) {
   SpringApplication.run(WebApplication.class, args);
}

}
