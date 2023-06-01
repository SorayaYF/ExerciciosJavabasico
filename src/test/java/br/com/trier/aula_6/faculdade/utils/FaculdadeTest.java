package br.com.trier.aula_6.faculdade.utils;
import br.com.trier.aula_6.faculdade.models.Professor;
import br.com.trier.aula_6.faculdade.enums.Formacao;
import br.com.trier.aula_6.faculdade.models.Aluno;
import br.com.trier.aula_6.faculdade.models.Disciplina;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FaculdadeTest {
	
    private Faculdade faculdade;

    @BeforeEach
    void iniciar() {
    	faculdade = new Faculdade();

        Professor professor1 = new Professor("Professor 1", Formacao.GRADUACAO);
        Professor professor2 = new Professor("Professor 2", Formacao.POS_GRADUACAO);

        Aluno aluno1 = new Aluno("Aluno 1");
        Aluno aluno2 = new Aluno("Aluno 2");

        Disciplina disciplina1 = new Disciplina("Disciplina 1", 40);
        Disciplina disciplina2 = new Disciplina("Disciplina 2", 60);

        disciplina1.setProfessor(professor1);
        disciplina2.setProfessor(professor2);

        faculdade.cadastrarProfessor(professor1);
        faculdade.cadastrarProfessor(professor2);

        faculdade.cadastrarAluno(aluno1);
        faculdade.cadastrarAluno(aluno2);

        faculdade.cadastrarDisciplina(disciplina1);
        faculdade.cadastrarDisciplina(disciplina2);

        faculdade.matricularAlunoEmDisciplina(aluno1, disciplina1);
        faculdade.matricularAlunoEmDisciplina(aluno1, disciplina2);
        faculdade.matricularAlunoEmDisciplina(aluno2, disciplina2);

        faculdade.adicionarNota(aluno1, disciplina1, 8.5);
        faculdade.adicionarNota(aluno1, disciplina2, 7.2);
        faculdade.adicionarNota(aluno2, disciplina2, 9.0);
    }

    @Test
    @DisplayName("Teste obter disciplinas com média de um aluno")
    void testObterDisciplinasComMedia() {
        Aluno aluno = faculdade.getAlunos().get(0);
        assertEquals(2, faculdade.obterDisciplinasComMedia(aluno).size());
    }

    @Test
    @DisplayName("Teste obter disciplinas lecionadas por professores com pós-graduação")
    void testObterDisciplinasComProfessorPosGraduacao() {
        assertEquals(1, faculdade.obterDisciplinasComProfessorPosGraduacao().size());
    }
    
    @Test
    @DisplayName("Teste cadastrar professor")
    void testCadastrarProfessor() {
        Professor professor = new Professor("Novo Professor", Formacao.GRADUACAO);
        faculdade.cadastrarProfessor(professor);
        assertEquals(3, faculdade.getProfessores().size());
    }

    @Test
    @DisplayName("Teste cadastrar aluno")
    void testCadastrarAluno() {
        Aluno aluno = new Aluno("Novo Aluno");
        faculdade.cadastrarAluno(aluno);
        assertEquals(3, faculdade.getAlunos().size());
    }

    @Test
    @DisplayName("Teste cadastrar disciplina")
    void testCadastrarDisciplina() {
        Professor professor = faculdade.getProfessores().get(0);
        Disciplina disciplina = new Disciplina("Nova Disciplina", 80);
        disciplina.setProfessor(professor);
        faculdade.cadastrarDisciplina(disciplina);
        assertEquals(3, faculdade.getDisciplinas().size());
    }

    @Test
    @DisplayName("Teste matricular aluno em disciplina inválida")
    void testMatricularAlunoEmDisciplinaInvalida() {
        Aluno aluno = faculdade.getAlunos().get(0);
        Disciplina disciplina = new Disciplina("Disciplina Inválida", 50);
        faculdade.matricularAlunoEmDisciplina(aluno, disciplina);
        assertEquals(0, aluno.getDisciplinasMatriculadas().size());
    }

    @Test
    @DisplayName("Teste obter média de um aluno em uma disciplina")
    void testObterMediaAlunoDisciplina() {
        Aluno aluno = faculdade.getAlunos().get(0);
        Disciplina disciplina = faculdade.getDisciplinas().get(0);
        double mediaEsperada = (8.5 + 7.2) / 2;
        assertEquals(mediaEsperada, faculdade.obterDisciplinasComMedia(aluno));
    }
}
