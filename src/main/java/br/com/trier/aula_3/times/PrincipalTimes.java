package br.com.trier.aula_3.times;

import javax.swing.JOptionPane;

public class PrincipalTimes {

	public static void main(String[] args) {
		Controller controller = new Controller();
		int op = 0;
		do {
			op = Util.escolheOp();

			switch (op) {
			case 1:
				controller.cadastrarTime();
                break;
            case 2:
            	controller.listarJogadoresTime();
                break;
            case 3:
            	controller.verificarArtilheiro();
                break;
            case 4:
            	controller.verificarTimeMaisGols();
                break;
			case 5:
				JOptionPane.showMessageDialog(null, "Encerrando o programa...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
				break;
			}
		} while (op != 5);

	}

}
