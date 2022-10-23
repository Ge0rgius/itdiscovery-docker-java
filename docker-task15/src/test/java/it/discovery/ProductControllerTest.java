package it.discovery;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import it.discovery.model.Product;
import it.discovery.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Testcontainers
@AutoConfigureDataJpa
@AutoConfigureEmbeddedDatabase
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ProductControllerTest {

//	@Container
//	static MySQLContainer mysql = new MySQLContainer<>("mysql:8")
//			.withExposedPorts(3306).withReuse(true);

//	@DynamicPropertySource
//	static void mysqlProperties(DynamicPropertyRegistry registry) {
//		registry.add("spring.datasource.url",
//				() -> String.format("jdbc:mysql://localhost:%s/test",
//						mysql.getMappedPort(3306)));
//	}

	@Autowired
	ProductRepository productRepository;

	@Test
	void saveProduct_success() {
		Product product = new Product();

		product.setName("Computer");
		productRepository.save(product);

		Product product1 = productRepository.findById(product.getId()).orElseThrow();
		assertEquals(product.getName(), product1.getName());

	}
}
