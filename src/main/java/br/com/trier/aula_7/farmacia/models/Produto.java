package br.com.trier.aula_7.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
	private String nome;
	private int estoque;
	private double valor;

	public void decrementarEstoque(int quantidade) {
		estoque -= quantidade;
	}

}
