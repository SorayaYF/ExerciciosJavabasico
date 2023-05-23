package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class PrincipalCarros {

	public static void main(String[] args) {
		CarroController controller = new CarroController();
		int op = 0;
		do {
			op = Util.escolheOp();

			switch (op) {
			case 1:
				controller.cadastrarCarro();
				break;
			case 2:
				controller.listarCarrosPorPeriodo();
				break;
			case 3:
				controller.listarCarrosPorMarca();
				break;
			case 4:
				controller.listarCarrosPorCor();
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
