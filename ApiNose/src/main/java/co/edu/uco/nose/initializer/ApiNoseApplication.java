package co.edu.uco.nose.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "co.edu.uco.nose" })
@SpringBootApplication
public class ApiNoseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNoseApplication.class, args);
	}

}
