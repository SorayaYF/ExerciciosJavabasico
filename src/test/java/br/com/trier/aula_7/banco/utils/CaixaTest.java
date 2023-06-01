package br.com.trier.aula_7.banco.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_7.banco.models.ContaCorrente;
import br.com.trier.aula_7.banco.models.ContaEspecial;
import br.com.trier.aula_7.banco.models.ContaUniversitaria;

class CaixaTest {
	
	private Caixa caixa;
	
	private ContaCorrente contaCorrente;
	
	private ContaEspecial contaEspecial;
	
	private ContaUniversitaria contaUniversitaria;
	
	@BeforeEach
    void init() {
		caixa = new Caixa();

        contaCorrente = new ContaCorrente("123456", "001", "John Doe", 1000.0);
        contaEspecial = new ContaEspecial("654321", "002", "Jane Smith", 2000.0, 1000.0);
        contaUniversitaria = new ContaUniversitaria("987654", "003", "Alice Johnson", 1500.0);

        caixa.cadastrarConta(contaCorrente);
        caixa.cadastrarConta(contaEspecial);
        caixa.cadastrarConta(contaUniversitaria);
    }

    @Test
    @DisplayName("Teste depósito em conta corrente")
    void testDepositoContaCorrente() {
    	caixa.realizarOperacao(contaCorrente, "DEPOSITO", 500.0);
        assertEquals(1500.0, contaCorrente.getSaldo());
    }

    @Test
    @DisplayName("Teste saque em conta corrente com saldo suficiente")
    void testSaqueContaCorrenteSaldoSuficiente() {
        assertTrue(caixa.realizarOperacao(contaCorrente, "SAQUE", 500.0));
        assertEquals(500.0, contaCorrente.getSaldo());
    }

    @Test
    @DisplayName("Teste saque em conta corrente com saldo insuficiente")
    void testSaqueContaCorrenteSaldoInsuficiente() {
        assertFalse(caixa.realizarOperacao(contaCorrente, "SAQUE", 1500.0));
        assertEquals(1000.0, contaCorrente.getSaldo());
    }

    @Test
    @DisplayName("Teste depósito em conta especial")
    void testDepositoContaEspecial() {
    	caixa.realizarOperacao(contaEspecial, "DEPOSITO", 500.0);
        assertEquals(2500.0, contaEspecial.getSaldo());
    }

    @Test
    @DisplayName("Teste saque em conta especial dentro do limite")
    void testSaqueContaEspecialDentroDoLimite() {
        assertTrue(caixa.realizarOperacao(contaEspecial, "SAQUE", 1500.0));
        assertEquals(500.0, contaEspecial.getSaldo());
    }

    @Test
    @DisplayName("Teste saque em conta especial além do limite")
    void testSaqueContaEspecialAlemDoLimite() {
        assertFalse(caixa.realizarOperacao(contaEspecial, "SAQUE", 3000.0));
        assertEquals(2000.0, contaEspecial.getSaldo());
    }

    @Test
    @DisplayName("Teste depósito em conta universitária")
    void testDepositoContaUniversitaria() {
    	caixa.realizarOperacao(contaUniversitaria, "DEPOSITO", 500.0);
        assertEquals(2000.0, contaUniversitaria.getSaldo());
    }

    @Test
    @DisplayName("Teste saque em conta universitária com saldo suficiente")
    void testSaqueContaUniversitariaSaldoSuficiente() {
        assertTrue(caixa.realizarOperacao(contaUniversitaria, "SAQUE", 1000.0));
        assertEquals(500.0, contaUniversitaria.getSaldo());
    }

    @Test
    @DisplayName("Teste saque em conta universitária com saldo insuficiente")
    void testSaqueContaUniversitariaSaldoInsuficiente() {
        assertFalse(caixa.realizarOperacao(contaUniversitaria, "SAQUE", 2000.0));
        assertEquals(1500.0, contaUniversitaria.getSaldo());
    }

    @Test
    @DisplayName("Teste transferência entre contas")
    void testTransferenciaEntreContas() {
        ContaCorrente contaDestino = new ContaCorrente("789012", "004", "Bob Brown", 0.0);
        caixa.cadastrarConta(contaDestino);

        assertTrue(caixa.realizarTransferencia(contaCorrente, contaDestino, 500.0));
        assertEquals(500.0, contaCorrente.getSaldo());
        assertEquals(500.0, contaDestino.getSaldo());
    }



}
