package com.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ems.security.jwt.JwtProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
		log.info("WELCOME TO EMS");
	}

}
