package br.com.trier.aula_6.faculdade.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Disciplina {

	@NonNull
	private String nome;
	@NonNull
	private int cargaHoraria;
	private Professor professor;
	private List<Aluno> alunosMatriculados = new ArrayList<>();

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void addAlunoMatriculado(Aluno aluno) {
		alunosMatriculados.add(aluno);
	}

}
