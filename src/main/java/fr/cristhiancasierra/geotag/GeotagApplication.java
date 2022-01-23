package fr.cristhiancasierra.geotag;

// import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(scanBasePackages = { "fr.cristhiancasierra.geotag" })
public class GeotagApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeotagApplication.class, args);
	}

}
