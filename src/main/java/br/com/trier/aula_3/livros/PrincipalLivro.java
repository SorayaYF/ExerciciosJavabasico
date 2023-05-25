package br.com.trier.aula_3.livros;

import javax.swing.JOptionPane;

import java.util.List;
import java.util.ArrayList;

public class PrincipalLivro {

	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<Livro>();
		List<Autor> autores = new ArrayList<Autor>();

		CadastroAutor cadastroAutor = new CadastroAutor();
		CadastroLivro cadastroLivro = new CadastroLivro();
		ListaLivros listaLivros = new ListaLivros();
		PesquisaLivro pesquisaLivro = new PesquisaLivro();

		int op = 0;
		do {
			op = Util.escolheOp();
			switch (op) {
			case 1:
				cadastroAutor.cadastrarAutor(autores);
				break;
			case 2:
				cadastroLivro.cadastrarLivro(livros, autores);
				break;
			case 3:
				listaLivros.listarTodosLivros(livros);
				break;
			case 4:
				pesquisaLivro.pesquisarLivrosPorAutor(livros, autores);
				break;
			case 5:
				pesquisaLivro.pesquisarLivrosPorFaixaDeValor(livros);
				break;
			case 6:
				listaLivros.listarLivrosComAutoresCrianca(livros);
				break;
			case 7:
				pesquisaLivro.pesquisarLivrosPorSexoAutor(livros);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Encerrando o programa...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
				break;
			}

		} while (op != 8);

	}
}
