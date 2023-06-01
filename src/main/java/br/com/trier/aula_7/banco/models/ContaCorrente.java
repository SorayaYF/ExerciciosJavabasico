package br.com.trier.aula_7.banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContaCorrente {

	private String numero;
	private String agencia;
	private String nomeCorrentista;
	private double saldo;

	public boolean deposito(double vl) {
		if (vl > 0) {
			saldo = getSaldo() + vl;
			return true;
		}
		return false;
	}

	public boolean saque(double valor) {
		if (valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}

	public boolean transferencia(ContaCorrente contaDestino, double valor) {
		if (saque(valor)) {
			contaDestino.deposito(valor);
			return true;
		}
		return false;
	}

}
