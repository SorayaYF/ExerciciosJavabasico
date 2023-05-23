package br.com.trier.aula_1;

import javax.swing.JOptionPane;

public class CalcularIMC {

	public static void main(String[] args) {

		int quantidadePessoas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas: "));

		for (int i = 1; i <= quantidadePessoas; i++) {
			JOptionPane.showMessageDialog(null, "Dados da pessoa " + i);

			String nome = JOptionPane.showInputDialog("Nome: ");

			String sexo = JOptionPane.showInputDialog("Sexo (M/F): ");

			double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso (kg): "));

			double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura (m): "));

			double imc = calcularIMC(peso, altura);
			String avaliacao = avaliarIMC(imc, sexo);

			JOptionPane.showMessageDialog(null, "\n--- Resultado ---" + "\nNome: " + nome + "\nIMC: " + imc
					+ "\nAvaliação do IMC: " + avaliacao + "\n-----------------\n");
		}
	}
	
	public static double calcularIMC(double peso, double altura) {
		return peso / (altura * altura);
	}

	public static String avaliarIMC(double imc, String sexo) {
		if (sexo.equalsIgnoreCase("M")) {
			if (imc < 20.7) {
				return "Abaixo do peso";
			} else if (imc >= 20.7 || imc <= 26.4) {
				return "Peso ideal";
			} else if (imc >= 26.5 || imc <= 27.8) {
				return "Pouco acima do peso";
			} else if (imc >= 27.9 || imc <= 31.1) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		} else if (sexo.equalsIgnoreCase("F")) {
			if (imc < 19.1) {
				return "Abaixo do peso";
			} else if (imc >= 19.1 || imc <= 25.8) {
				return "Peso ideal";
			} else if (imc >= 25.9 || imc <= 27.3) {
				return "Pouco acima do peso";
			} else if (imc >= 27.4 || imc <= 32.3) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		} else {
			return "Sexo inválido";
		}
	}
}
