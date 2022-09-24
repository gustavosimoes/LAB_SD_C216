package br.inatel.labs.labrest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest.client.model.Curso;

public class WebClientDeleteCurso {
	public static void main(String[] args) {
		ResponseEntity response = WebClient.create("http://localhost:8080")
				.delete()
				.uri("/curso/3")
				.retrieve()
				.toBodilessEntity().block();

		System.out.println(response.getStatusCodeValue());

	}
}
