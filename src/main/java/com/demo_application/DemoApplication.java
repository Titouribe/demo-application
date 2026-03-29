package com.demo_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque para la aplicación Spring Boot.
 * <p>
 * Inicializa el contexto de Spring y lanza la aplicación DemoApplication.
 * </p>
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot.
	 * 
	 * @param args Argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
