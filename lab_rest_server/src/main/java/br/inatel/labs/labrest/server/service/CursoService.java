package br.inatel.labs.labrest.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.inatel.labs.labrest.server.model.Curso;

@Service
public class CursoService {

	private List<Curso> listaCursos = new ArrayList<Curso>();

	@PostConstruct
	private void setup() {
		Curso curso1 = new Curso(1L, "UI/UX", 20);
		Curso curso2 = new Curso(2L, "Desenvolvimento Mobile com Flutter", 80);
		Curso curso3 = new Curso(3L, "Flutter + Dart", 120);

		listaCursos.add(curso1);
		listaCursos.add(curso2);
		listaCursos.add(curso3);

	}

	public List<Curso> procurarCurso() {
		return listaCursos;
	}

	public Optional<Curso> buscarCursoPeloId(Long cursoId) {
		return listaCursos.stream().filter(e -> e.getId().equals(cursoId)).findFirst();

	}

	public Curso criarCurso(Curso curso) {
		Long id = new Random().nextLong();
		curso.setId(id);
		listaCursos.add(curso);
		return curso;
	}

	public void editarCurso(Curso curso) {
		listaCursos.remove(curso);
		listaCursos.add(curso);
	}

	public void removerCurso(Curso curso) {
		listaCursos.remove(curso);
	}

}
