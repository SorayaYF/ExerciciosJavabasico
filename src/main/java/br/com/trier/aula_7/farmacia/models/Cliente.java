package br.com.trier.aula_7.farmacia.models;

import lombok.Getter;

@Getter
public class Cliente {

	private String nome;
	private double saldoDevedor;
	
    public Cliente(String nome) {
        this.nome = nome;
        this.saldoDevedor = 0.0;
    }


	public void incrementarSaldoDevedor(double valor) {
		saldoDevedor += valor;
	}

	public void decrementarSaldoDevedor(double valor) {
		saldoDevedor -= valor;
	}

}
