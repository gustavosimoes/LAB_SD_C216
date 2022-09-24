package br.inatel.labs.labrest.client;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest.client.model.Curso;

public class WebClientPostCurso {

	public static void main(String[] args) {
		Curso newCurso = new Curso();
		newCurso.setCargaHoraria(100);
		newCurso.setDescricao("Curso novo de Culinária");

		Curso createdCurso = WebClient.create("http://localhost:8080").post().uri("/curso").bodyValue(newCurso)
				.retrieve().bodyToMono(Curso.class).block();

		System.out.println(createdCurso.getId());
		System.out.println(createdCurso.getDescricao());

	}

}
