package com.present.webdrawer;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.present.webdrawer.repositories.BaseRepositoryCustomImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "WebDrawer APIs", version = "0.0.1"))
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryCustomImpl.class, basePackages = "com.present.webdrawer.repositories")
@ConfigurationPropertiesScan("com.present.webdrawer.profiles.configuration")
public class WebdrawerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebdrawerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();

	}

	// Useful for dev testing
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {

		};
	}

	/**
	 * Avvio del server H2 interno in modo da rendere il DB visibile da DB tools
	 * esterni
	 *
	 * @return H2 Server instance
	 * @throws SQLException
	 */
	@Profile("local")
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}
	

	

}