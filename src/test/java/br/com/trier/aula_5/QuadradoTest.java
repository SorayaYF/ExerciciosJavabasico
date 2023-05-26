package br.com.trier.aula_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadradoTest {

	@Test
	void test() {
		TestandoJUnit teste = new TestandoJUnit();
		int  output = teste.quadrado(5);
		assertEquals(25, output);
	}

}
