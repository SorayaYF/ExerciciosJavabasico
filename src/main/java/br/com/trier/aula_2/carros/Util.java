package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Util {

	static int escolheOp() {
		String menu = "Menu:\n" 
				+ "1 – Cadastrar Carro\n" 
				+ "2 – Listar os carros por período de fabricação\n"
				+ "3 – Listar carros por marca\n" 
				+ "4 – Listar carros por cor\n" 
				+ "5 – Sair\n" + "Escolha uma opção:";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
