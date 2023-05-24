package br.com.trier.aula_3.times;

import javax.swing.JOptionPane;

public class Util {
	static int escolheOp() {
		String menu = "Menu:\n" 
				+ "1 – Cadastrar times\n" 
				+ "2 – Listar jogadores de um time\n"
				+ "3 – Verificar artilheiro do campeonato\n" 
				+ "4 – Verificar time que fez mais gols no campeonato\n" 
				+ "5 – Sair\n" + "Escolha uma opção:";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
}
