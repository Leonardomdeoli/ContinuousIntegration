package br.com.continuous.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leonardo Mendes
 * 
 * Exemplo de integração continua com Travis utilizando banco de dados MYSQL
 * */

@SpringBootApplication
public class AppContext {
	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
	}
}
