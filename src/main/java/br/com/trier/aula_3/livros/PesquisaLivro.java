package br.com.trier.aula_3.livros;

import java.util.List;

import javax.swing.JOptionPane;

public class PesquisaLivro {
	
	public void pesquisarLivrosPorAutor(List<Livro> livros, List<Autor> autores) {
        List<String> opcoesAutores = Autor.getNomesAutores(autores);

        Object selecionaAutor = JOptionPane.showInputDialog(null, "Selecione o autor:", "Pesquisar por Autor",
                JOptionPane.PLAIN_MESSAGE, null, opcoesAutores.toArray(), opcoesAutores.get(0));

        if (selecionaAutor == null) {
            return;
        }

        String nomeAutorSelecionado = selecionaAutor.toString();
        StringBuilder lista = new StringBuilder();
        lista.append("===== LIVROS DO AUTOR ").append(nomeAutorSelecionado).append(" =====\n");
        boolean encontrou = false;

        for (Livro livro : livros) {
            boolean possuiAutor = false;
            for (Autor autor : livro.getAutores()) {
                String nomeAutor = autor.getNome() + " " + autor.getSobrenome();
                if (nomeAutor.equals(nomeAutorSelecionado)) {
                    possuiAutor = true;
                    break;
                }
            }

            if (possuiAutor) {
                lista.append(livro);
                lista.append("\n\n");
                encontrou = true;
            }
        }

        if (!encontrou) {
            lista.append("Nenhum livro encontrado para o autor ").append(nomeAutorSelecionado).append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }


	public void pesquisarLivrosPorSexoAutor(List<Livro> livros) {
		String[] opcoesSexo = { "Masculino", "Feminino" };
		int opcaoSexo = JOptionPane.showOptionDialog(null, "Selecione o sexo do autor:", "Sexo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoesSexo, opcoesSexo[0]);
		Sexo sexo;
		if (opcaoSexo == 0) {
			sexo = Sexo.MASCULINO;
		} else {
			sexo = Sexo.FEMININO;
		}

		StringBuilder lista = new StringBuilder();
		lista.append("===== LIVROS ").append(sexo).append("S =====\n");
		boolean encontrou = false;

		for (Livro livro : livros) {
			boolean possuiAutorSexo = true;
			for (Autor autor : livro.getAutores()) {
				if (autor.getSexo() != sexo) {
					possuiAutorSexo = false;
					break;
				}
			}

			if (possuiAutorSexo) {
				lista.append(livro);
				lista.append("\n\n");
				encontrou = true;
			}
		}

		if (!encontrou) {
			lista.append("Nenhum livro encontrado com autores do sexo informado.\n");
		}

		JOptionPane.showMessageDialog(null, lista.toString());
	}

	public void pesquisarLivrosPorFaixaDeValor(List<Livro> livros) {
		String valorMinStr = JOptionPane.showInputDialog("Digite o valor mínimo:");
		String valorMaxStr = JOptionPane.showInputDialog("Digite o valor máximo:");

		double valorMin, valorMax;
		try {
			valorMin = Double.parseDouble(valorMinStr);
			valorMax = Double.parseDouble(valorMaxStr);
			if (valorMin <= 0 || valorMax <= 0 || valorMax < valorMin) {
				JOptionPane.showMessageDialog(null, "Valores inválidos. Pesquisa cancelada.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valores inválidos. Pesquisa cancelada.");
			return;
		}

		StringBuilder lista = new StringBuilder();
		lista.append("===== LIVROS NA FAIXA DE VALOR R$").append(valorMin).append(" - R$").append(valorMax)
				.append(" =====\n");
		boolean encontrou = false;

		for (Livro livro : livros) {
			double preco = livro.getPreco();
			if (preco >= valorMin && preco <= valorMax) {
				lista.append(livro);
				lista.append("\n\n");
				encontrou = true;
			}
		}

		if (!encontrou) {
			lista.append("Nenhum livro encontrado na faixa de valor informada.\n");
		}

		JOptionPane.showMessageDialog(null, lista.toString());
	}

}
