package br.com.trier.aula_3.livros;

import java.util.List;

import javax.swing.JOptionPane;

public class CadastroAutor {
	public void cadastrarAutor(List<Autor> autores) {
		String nome;
		String sobrenome;
		int idade;

		do {
			nome = JOptionPane.showInputDialog("Digite o nome do autor:");

			if (nome == null) {
				return;
			}

		} while (nome.isEmpty());

		do {
			sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do autor:");

			if (sobrenome == null) {
				return;
			}

		} while (sobrenome.isEmpty());

		String[] opcoesSexo = { "Masculino", "Feminino" };
		int opcaoSexo = JOptionPane.showOptionDialog(null, "Selecione o sexo do autor:", "Sexo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoesSexo, opcoesSexo[0]);
		Sexo sexo;
		if (opcaoSexo == 0) {
			sexo = Sexo.MASCULINO;
		} else {
			sexo = Sexo.FEMININO;
		}
		
		do {
			String digitaIdade = JOptionPane.showInputDialog("Digite a idade do autor:");
			if (digitaIdade == null) {
				return;
			}
			try {
				idade = Integer.parseInt(digitaIdade);
				if (idade <= 0) {
					JOptionPane.showMessageDialog(null, "Idade inválida. Cadastro cancelado.");
					return;
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Idade inválida. Digite novamente.");
			}
		} while (true);

		Autor autor = new Autor(nome, sobrenome, sexo, idade);
		autores.add(autor);

		JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
	}

}
