package br.com.trier.aula_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContadorTest {

	@Test
	void test() {
		TestandoJUnit teste = new TestandoJUnit();
		int  output = teste.contadorDePalavras("Palmeiras");
		assertEquals(2, output);
	}

}
