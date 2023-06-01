package br.com.trier.aula_7.banco.models;

import lombok.Getter;

@Getter
public class ContaEspecial extends ContaCorrente {

	private double limite;

	public ContaEspecial(String numero, String agencia, String nomeCorrentista, double saldo, double limite) {
		super(numero, agencia, nomeCorrentista, saldo);
		this.limite = limite;
	}

	@Override
	public boolean saque(double valor) {
		if (valor <= (getSaldo() + limite)) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}
}
