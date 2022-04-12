package com.wolkersomar;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableRabbit
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories (basePackages = {"com.wolkersomar.repository"})
@ComponentScan (basePackages = {"com.*"})
public class WolkerDeSomaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WolkerDeSomaApplication.class, args);
	}

}
