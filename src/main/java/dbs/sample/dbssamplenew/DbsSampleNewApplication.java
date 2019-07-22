package dbs.sample.dbssamplenew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DbsSampleNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsSampleNewApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurerAdapter corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				/**
				 * By default all origins and GET, HEAD and POST methods are allowed.
				 */
				registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE");
			}

		};
	}

}
