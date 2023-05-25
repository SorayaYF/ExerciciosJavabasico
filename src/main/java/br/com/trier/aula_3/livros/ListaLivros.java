package br.com.trier.aula_3.livros;

import java.util.List;

import javax.swing.JOptionPane;

public class ListaLivros {
	public void listarTodosLivros(List<Livro> livros) {
		StringBuilder lista = new StringBuilder();
		lista.append("===== LISTA DE LIVROS =====\n");
		for (Livro livro : livros) {
			lista.append(livro);
			lista.append("\n\n");
		}
		JOptionPane.showMessageDialog(null, lista.toString());
	}

	public void listarLivrosComAutoresCrianca(List<Livro> livros) {
		StringBuilder lista = new StringBuilder();
		lista.append("===== LISTA DE LIVROS COM AUTORES CRIANÇAS =====\n");
		boolean encontrou = false;

		for (Livro livro : livros) {
			boolean possuiAutorCrianca = false;
			for (Autor autor : livro.getAutores()) {
				if (autor.getIdade() <= 12) {
					possuiAutorCrianca = true;
					break;
				}
			}

			if (possuiAutorCrianca) {
				lista.append(livro);
				lista.append("\n\n");
				encontrou = true;
			}
		}

		if (!encontrou) {
			lista.append("Nenhum livro encontrado com autores crianças.\n");
		}

		JOptionPane.showMessageDialog(null, lista.toString());
	}

}
