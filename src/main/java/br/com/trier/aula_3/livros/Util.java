package br.com.trier.aula_3.livros;

import javax.swing.JOptionPane;

public class Util {
	static int escolheOp() {
		String menu = "Menu:\n" 
				+ "1 – Cadastrar Autor\n" 
				+ "2 – Cadastrar Livro\n"
				+ "3 – Listar todos os livros cadastrados\n" 
				+ "4 – Pesquisar por autor\n" 
				+ "5 - Pesquisar por faixa de valor do livro\n"
				+ "6 - Listar todos os livros cujos autores tenham crianças\n"
				+ "7 - Listar todos os livros escritos apenas por mulheres ou homens\n"
				+ "8 – Sair\n" + "Escolha uma opção:";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
