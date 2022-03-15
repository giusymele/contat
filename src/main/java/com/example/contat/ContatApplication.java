package com.example.contat;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
//@EnableJpaRepositories(basePackages = "com.example.repository")
//@EntityScan(basePackages = {"com.example.contat"})
//@ComponentScan("com.example.contat")
//@EnableAutoConfiguration
//@EntityScan({"com.example.entity"})
@SpringBootApplication
public class ContatApplication {
	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ContatApplication.class, args);

	}

	//@Override
//	public void run(String... args) throws Exception {
//
//		String query = "INSERT INTO UTENTI(EMAIL, PASSWORD) VALUES('UTENTE@UTENTE.IT','CIAO')";
//	
//	
//	int result=	jdbcTemplate.update(query);
//	
//	if(result>0) {
//		
//		System.out.print("nuovo utente inserito ");
//	}
//	else {
//	
//		System.out.print("utente non inserito ");
//	}
	
		
	
	

}
