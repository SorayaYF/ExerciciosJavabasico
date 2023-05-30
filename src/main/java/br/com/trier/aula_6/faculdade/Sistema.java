package br.com.trier.aula_6.faculdade;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

import java.util.ArrayList;


@Getter
public class Sistema {
	
	private List<Professor> professores;
	private List<Disciplina> disciplinas;
	private List<Aluno> alunos;

	public Sistema() {
		this.professores = new ArrayList<Professor>();
		this.disciplinas = new ArrayList<Disciplina>();
		this.alunos = new ArrayList<Aluno>();
	}
	
	public void cadastrarProfessor(String nome, Formacao formacao) {
		Professor professor = new Professor(nome, formacao);
		professores.add(professor);
	}

	public void cadastrarDisciplina(String nome, int cargaHoraria, Professor professor) {
		Disciplina disciplina = new Disciplina(nome, cargaHoraria, professor);
		disciplinas.add(disciplina);
	}

	public void cadastrarAluno(String nome) {
		Aluno aluno = new Aluno(nome);
		alunos.add(aluno);
	}

	public void matricularAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
		aluno.matricularDisciplina(disciplina);
	}

	public void informarNotasAlunoEmDisciplina(Aluno aluno, Disciplina disciplina, List<Double> notas) {
		aluno.informarNotas(disciplina, notas);
	}

	public List<Disciplina> listarDisciplinasComMediaDoAluno(Aluno aluno) {
		return aluno.getDisciplinasComMedia();
	}

	public List<Disciplina> listarDisciplinasLecionadasPorProfessoresComPosGraduacao() {
		return disciplinas.stream()
				.filter(disciplina -> disciplina.getProfessor().getFormacao() == Formacao.POS_GRADUACAO)
				.collect(Collectors.toList());
	}

}
