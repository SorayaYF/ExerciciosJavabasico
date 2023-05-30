package br.com.trier.aula_6.medicamento;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgramaTest {
	
	private Programa programa;
	
	@BeforeEach
	void iniciar() {
		programa = new Programa();
	}
	
	@Test
    void testCadastrarMedicamento() {
        programa.cadastrarMedicamento("Paracetamol", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));

        List<Medicamento> medicamentos = programa.getMedicamentos();
        assertEquals(1, medicamentos.size());
        assertEquals("Paracetamol", medicamentos.get(0).getNome());
    }
	
	@Test
    void testCadastrarPessoa() {
        programa.cadastrarPessoa("João", "Dor de cabeça", new ArrayList<>());

        List<Pessoa> pessoas = programa.getPessoas();
        assertEquals(1, pessoas.size());
        assertEquals("João", pessoas.get(0).getNome());
    }
	
	@Test
    void testListarPessoasEMedicamentos() {
        programa.cadastrarMedicamento("Paracetamol", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));

        programa.cadastrarPessoa("João", "Dor de cabeça", new ArrayList<>());

        programa.prescreverMedicamento("João", "Paracetamol");

        String expectedOutput = "Pessoa: João\n" +
                                "Medicamentos prescritos:\n" +
                                "- Paracetamol\n\n";
        
        
        assertEquals(expectedOutput, programa.listarPessoasEMedicamentos());
    }

    @Test
    void testPrescreverMedicamento() {
        programa.cadastrarMedicamento("Paracetamol", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));
        programa.cadastrarMedicamento("Dipirona", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));
        programa.cadastrarMedicamento("Insulina", EnumAdministracao.INJETÀVEL, new ArrayList<>(), List.of("Diabetes"));
        programa.cadastrarMedicamento("Creme dermatológico", EnumAdministracao.TÓPICO, new ArrayList<>(), List.of("Dermatite"));

        programa.cadastrarPessoa("João", "Dor de cabeça", new ArrayList<>());
        programa.cadastrarPessoa("Maria", "Febre", new ArrayList<>());
        programa.cadastrarPessoa("Pedro", "Diabetes", new ArrayList<>());
        programa.cadastrarPessoa("Ana", "Dermatite", new ArrayList<>());

        programa.prescreverMedicamento("João", "Paracetamol");
        programa.prescreverMedicamento("Maria", "Dipirona");
        programa.prescreverMedicamento("Pedro", "Insulina");
        programa.prescreverMedicamento("Ana", "Creme dermatológico");

        List<Medicamento> medicamentosJoao = programa.getPessoaMedicamentos("João");
        assertEquals(1, medicamentosJoao.size());
        assertEquals("Paracetamol", medicamentosJoao.get(0).getNome());

        List<Medicamento> medicamentosMaria = programa.getPessoaMedicamentos("Maria");
        assertEquals(1, medicamentosMaria.size());
        assertEquals("Dipirona", medicamentosMaria.get(0).getNome());

        List<Medicamento> medicamentosPedro = programa.getPessoaMedicamentos("Pedro");
        assertEquals(1, medicamentosPedro.size());
        assertEquals("Insulina", medicamentosPedro.get(0).getNome());

        List<Medicamento> medicamentosAna = programa.getPessoaMedicamentos("Ana");
        assertEquals(1, medicamentosAna.size());
        assertEquals("Creme dermatológico", medicamentosAna.get(0).getNome());
        
        programa.prescreverMedicamento("João", "Dipirona");
        assertEquals(1, medicamentosJoao.size());

        programa.prescreverMedicamento("Pedro", "Creme dermatológico");
        assertEquals(0, medicamentosPedro.size());

        programa.prescreverMedicamento("Inexistente", "Paracetamol");
        programa.prescreverMedicamento("João", "Inexistente");
    }

    @Test
    void testPrescreverMedicamentoInvalido() {

        programa.cadastrarMedicamento("Paracetamol", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));
        programa.cadastrarMedicamento("Dipirona", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));
        programa.cadastrarMedicamento("Insulina", EnumAdministracao.INJETÀVEL, new ArrayList<>(), List.of("Diabetes"));
        programa.cadastrarMedicamento("Creme dermatológico", EnumAdministracao.TÓPICO, new ArrayList<>(), List.of("Dermatite"));

        programa.cadastrarPessoa("João", "Dor de cabeça", new ArrayList<>());

        assertFalse(programa.prescreverMedicamento("João", "Ibuprofeno"));
        assertFalse(programa.prescreverMedicamento("Inexistente", "Paracetamol"));
        assertFalse(programa.prescreverMedicamento("Maria", "Creme dermatológico"));

        List<Medicamento> medicamentosJoao = programa.getPessoaMedicamentos("João");
        assertEquals(0, medicamentosJoao.size());
    }

    @Test
    void testPrescreverMedicamentoAlergia() {
    	
        programa.cadastrarMedicamento("Paracetamol", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));
        programa.cadastrarMedicamento("Dipirona", EnumAdministracao.ORAL, new ArrayList<>(), List.of("Dor de cabeça", "Febre"));
        programa.cadastrarMedicamento("Insulina", EnumAdministracao.INJETÀVEL, new ArrayList<>(), List.of("Diabetes"));
        programa.cadastrarMedicamento("Creme dermatológico", EnumAdministracao.TÓPICO, List.of("Pessoa com alergia"), List.of("Dermatite"));

        programa.cadastrarPessoa("João", "Dor de cabeça", new ArrayList<>());
        programa.cadastrarPessoa("Maria", "Febre", List.of("Creme dermatológico"));

        assertFalse(programa.prescreverMedicamento("João", "Creme dermatológico"));
        assertFalse(programa.prescreverMedicamento("Maria", "Creme dermatológico"));

        List<Medicamento> medicamentosJoao = programa.getPessoaMedicamentos("João");
        assertEquals(0, medicamentosJoao.size());

        List<Medicamento> medicamentosMaria = programa.getPessoaMedicamentos("Maria");
        assertEquals(0, medicamentosMaria.size());
    }




}
