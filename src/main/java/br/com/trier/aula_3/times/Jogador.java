package br.com.trier.aula_3.times;

import lombok.Getter;
import lombok.Setter;

@Getter

public class Jogador {

	private String nome;
	private int numeroCamisa;
	private int golsMarcados;

	public Jogador(String nome, int numeroCamisa, int golsMarcados) {
		this.nome = nome;
		this.numeroCamisa = numeroCamisa;
		this.golsMarcados = golsMarcados;
	}
}
