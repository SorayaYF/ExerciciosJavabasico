package br.com.trier.aula_7.banco.utils;

import java.util.List;
import java.util.ArrayList;

import br.com.trier.aula_7.banco.models.ContaCorrente;

public class Caixa {
	
	private List<ContaCorrente> contas;

    public Caixa() {
        contas = new ArrayList<>();
    }

    public void cadastrarConta(ContaCorrente conta) {
        contas.add(conta);
    }

    public List<ContaCorrente> getContas() {
        return contas;
    }

	public boolean realizarOperacao(ContaCorrente conta, String operacao, double valor) {
		switch (operacao) {
		case "DEPOSITO":
			conta.deposito(valor);
			return true;
		case "SAQUE":
			return conta.saque(valor);
		default:
			return false;
		}
	}

	public boolean realizarTransferencia(ContaCorrente contaOrigem, ContaCorrente contaDestino, double valor) {
		return contaOrigem.transferencia(contaDestino, valor);
	}

}
