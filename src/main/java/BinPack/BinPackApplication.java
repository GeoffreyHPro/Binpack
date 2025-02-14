package BinPack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class BinPackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinPackApplication.class, args);
	}

}
