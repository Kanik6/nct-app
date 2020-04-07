package com.ort.ortnct;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class OrtNctApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(OrtNctApplication.class, args);
	}


	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	@Bean
	public Docket shopApi()
	{
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		ApiInfo metaData = new ApiInfo
				(
						"ORT-NCT Api Documentation",
						"Spring boot rest Api",
						"1.0",
						"Terms of conditions",
						new Contact("Neobis", "Neobis.ort.project@gmail.com", "Neobis.ort.project@gmail.com"),
						"Neobis license",
						"Neobis.com License"
				);

		return docket.select().apis(RequestHandlerSelectors
				.basePackage("com.ort.ortnct.controller")).build().apiInfo(metaData);
	}
}
