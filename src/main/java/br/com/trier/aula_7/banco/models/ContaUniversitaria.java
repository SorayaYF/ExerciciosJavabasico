package br.com.trier.aula_7.banco.models;

public class ContaUniversitaria extends ContaCorrente {

	private static final double LIMITE_SALDO = 2000.0;

	public ContaUniversitaria(String numero, String agencia, String nomeCorrentista, double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}

	@Override
	public boolean deposito(double vl) {
		if(getSaldo() + vl <= LIMITE_SALDO) {
			return super.deposito(vl);
		}
		return false;
	}

}
