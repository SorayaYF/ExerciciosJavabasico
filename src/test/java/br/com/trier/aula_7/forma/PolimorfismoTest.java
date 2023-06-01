package br.com.trier.aula_7.forma;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolimorfismoTest {
	
	private List<Forma> lista = new ArrayList<Forma>();

	@BeforeEach
	public void init() {
		lista.add(new Circulo(3));
		lista.add(new Cone());
		lista.add(new Quadrado());
		lista.add(new Triangulo());
		
	}
	
	@Test
	@DisplayName("Teste desenhar círculo")
	public void desenharCirculoTest() {
		String s = lista.get(0).desenhar();
		assertEquals("Desenhando um Círculo", s);
	}
	
	@Test
	@DisplayName("Teste área círculo")
	public void areaCirculoTest() {
		Circulo c = (Circulo) lista.get(0);
		double area = c.calculaArea();
		DecimalFormat df = new DecimalFormat("##.00");
		assertEquals("28,27", df);
	}
	
	@Test
	@DisplayName("Teste desenhar quadrado")
	public void desenharQuadradoTest() {
		String s = lista.get(2).desenhar();
		assertEquals("Desenhando um Quadrado com 4", s);
	}
	
	

}
