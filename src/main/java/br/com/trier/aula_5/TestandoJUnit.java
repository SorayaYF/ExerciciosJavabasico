package br.com.trier.aula_5;

public class TestandoJUnit {

	public int quadrado(int x) {
		return x * x;
	}

	public int contadorDePalavras(String palavra) {
		int count = 0;
		for(int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A') {
				count++;
			}
		}
		return count;
	}

}
