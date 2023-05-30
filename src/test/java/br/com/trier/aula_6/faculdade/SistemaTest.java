package br.com.trier.aula_6.faculdade;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SistemaTest {

    @Test
    void testSistema() {
    	
    	Sistema sistema = new Sistema();

    	sistema.cadastrarProfessor("Prof. João", Formacao.GRADUACAO);
    	sistema.cadastrarProfessor("Prof. Maria", Formacao.POS_GRADUACAO);

    	sistema.cadastrarDisciplina("Matemática", 60, sistema.getProfessores().get(0));
    	sistema.cadastrarDisciplina("Física", 50, sistema.getProfessores().get(1));

    	sistema.cadastrarAluno("José");
    	sistema.cadastrarAluno("Ana");

        Aluno aluno1 = sistema.getAlunos().get(0);
        Aluno aluno2 = sistema.getAlunos().get(1);

        Disciplina disciplina1 = sistema.getDisciplinas().get(0);
        Disciplina disciplina2 = sistema.getDisciplinas().get(1);

        sistema.matricularAlunoEmDisciplina(aluno1, disciplina1);
        sistema.matricularAlunoEmDisciplina(aluno2, disciplina2);

        List<Double> notas1 = new ArrayList<>();
        notas1.add(7.5);
        notas1.add(8.0);
        notas1.add(9.0);
        sistema.informarNotasAlunoEmDisciplina(aluno1, disciplina1, notas1);

        List<Double> notas2 = new ArrayList<>();
        notas2.add(6.0);
        notas2.add(7.0);
        notas2.add(8.0);
        sistema.informarNotasAlunoEmDisciplina(aluno2, disciplina2, notas2);

        List<Disciplina> disciplinasComMedia = sistema.listarDisciplinasComMediaDoAluno(aluno1);
        assertEquals(1, disciplinasComMedia.size());
        assertEquals("Matemática", disciplinasComMedia.get(0).getNome());
    }


}
