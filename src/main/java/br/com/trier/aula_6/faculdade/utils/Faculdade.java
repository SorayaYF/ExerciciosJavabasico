package br.com.trier.aula_6.faculdade.utils;

import br.com.trier.aula_6.faculdade.models.Professor;
import br.com.trier.aula_6.faculdade.enums.Formacao;
import br.com.trier.aula_6.faculdade.models.Aluno;
import br.com.trier.aula_6.faculdade.models.Disciplina;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Faculdade {
	private List<Professor> professores = new ArrayList<>();
	private List<Aluno> alunos = new ArrayList<>();
	private List<Disciplina> disciplinas = new ArrayList<>();

	public void cadastrarProfessor(Professor professor) {
		professores.add(professor);
	}

	public void cadastrarAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public void cadastrarDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	public void matricularAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
		if (alunos.contains(aluno) && disciplinas.contains(disciplina)) {
			aluno.adicionarDisciplina(disciplina);
			disciplina.addAlunoMatriculado(aluno);
		}
	}

	public void adicionarNota(Aluno aluno, Disciplina disciplina, double nota) {
		if (alunos.contains(aluno) && disciplinas.contains(disciplina)) {
			aluno.adicionarNota(disciplina, nota);
		}
	}

	public List<Disciplina> obterDisciplinasComMedia(Aluno aluno) {
		if (alunos.contains(aluno)) {
			return aluno.getDisciplinasMatriculadas();
		}
		return new ArrayList<>();
	}

	public List<Disciplina> obterDisciplinasComProfessorPosGraduacao() {
		List<Disciplina> disciplinasComProfessorPosGraduacao = new ArrayList<>();
		for (Disciplina disciplina : disciplinas) {
			Professor professor = disciplina.getProfessor();
			if (professor != null && professor.getFormacao() == Formacao.POS_GRADUACAO) {
				disciplinasComProfessorPosGraduacao.add(disciplina);
			}
		}
		return disciplinasComProfessorPosGraduacao;
	}

}
