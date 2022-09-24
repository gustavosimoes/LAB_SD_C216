package br.inatel.labs.labrest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest.client.model.Curso;

public class WebClientPutCurso {
	public static void main(String[] args) {
		Curso newCurso = new Curso();
		newCurso.setId(1L);
		newCurso.setCargaHoraria(100);
		newCurso.setDescricao("Curso novo de Culinária");

		ResponseEntity response = WebClient.create("http://localhost:8080")
				.put()
				.uri("/curso")
				.bodyValue(newCurso)
				.retrieve()
				.toBodilessEntity().block();

		System.out.println(response.getStatusCodeValue());

	}
}
