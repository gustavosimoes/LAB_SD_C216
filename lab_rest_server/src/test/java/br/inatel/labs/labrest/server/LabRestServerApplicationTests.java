package br.inatel.labs.labrest.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LabRestServerApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void deveListarCursos() {
			webTestClient.get()
			.uri("/curso")
			.exchange()
			.expectHeader().contentType(MediaType.APPLICATION_JSON)
			.expectStatus().isOk()
			.expectBody().returnResult();
			
			
	}

}
