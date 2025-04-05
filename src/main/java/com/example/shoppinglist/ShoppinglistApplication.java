package com.example.shoppinglist;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppinglistApplication {

	static {
		Dotenv dotenv = Dotenv.configure()
				.filename(".env")
				.directory("./") // diretório onde está o .env
				.ignoreIfMissing() // evita exception se não encontrar
				.load();

		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
	}


	public static void main(String[] args) {
		SpringApplication.run(ShoppinglistApplication.class, args);
	}

}
