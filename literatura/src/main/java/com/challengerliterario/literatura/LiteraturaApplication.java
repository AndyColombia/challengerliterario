package com.challengerliterario.literatura;


import com.challengerliterario.literatura.console.CatalogoConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiteraturaApplication.class, args);
		CatalogoConsole console = context.getBean(CatalogoConsole.class);
		console.iniciar();
	}
}