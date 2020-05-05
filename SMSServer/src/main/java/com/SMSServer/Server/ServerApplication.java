package com.SMSServer.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ServerApplication {
	
	public ServerApplication() {
    }

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
