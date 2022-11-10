package com.vic.testcontainers;

import com.vic.testcontainers.model.Persona;
import com.vic.testcontainers.repository.PersonaRepository;
import com.vic.testcontainers.service.PersonaService;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class TestcontainersApplicationTests {

//	@Autowired
//	PersonaService personaService;

	@Autowired
	PersonaRepository personaRepository;

	@Container
	public static DockerComposeContainer environment =
			new DockerComposeContainer(new File("docker-compose.yml"))
					.withExposedService("redis_1", 9999)
					//.withExposedService("postgre_1", 5433)
					.withLocalCompose(false);

/*	@Container
	private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.5")
			.withUsername("user")
			.withPassword("password")
			.withDatabaseName("db");

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
		dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
	}

	@BeforeEach
	public void setUp(){
	//	postgreSQLContainer.start();
	}

	@Test
	public void should_setUpDb_when_fliwayMigrate(){

		Flyway flyway = Flyway.configure().dataSource(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword()).load();
		MigrateResult migrateResult = flyway.migrate();
		Assertions.assertTrue(migrateResult.success);

	}

	@Test
	public void should_returnPersonList_when_findAllIsCalledInPersonaRepository(){
		List<Persona> customers = personaRepository.findAll();
		Assertions.assertEquals(customers.size(),2);

	}
*/
	@Test
	public void should_startRedis_when_initialize(){
		//environment.start();
		String redisUrl =
				environment.getServiceHost("redis_1", 9999)
						+ ":" +
				environment.getServicePort("redis_1", 9999);
		Assertions.assertNotNull(redisUrl);
		System.out.println("url:"+ redisUrl);
	}



}
