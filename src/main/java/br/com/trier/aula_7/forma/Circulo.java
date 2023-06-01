package br.com.trier.aula_7.forma;

import lombok.Getter;

@Getter
public class Circulo extends Forma {
	
	private int raio;
	
	public Circulo(int raio) {
		super("Círculo");
		this.raio = raio;
	}
	
	public double calculaArea() {
		return Math.PI * Math.pow(raio, 2);
	}

}
