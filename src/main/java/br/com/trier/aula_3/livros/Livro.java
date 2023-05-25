package br.com.trier.aula_3.livros;

import java.util.List;
import java.util.ArrayList;
import lombok.Getter;

@Getter

public class Livro {
	private String titulo;
	private double preco;
	private List<Autor> autores;
	
	public Livro(String titulo, double preco) {
		this.titulo = titulo;
		this.preco = preco;
		this.autores = new ArrayList<Autor>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Título: ").append(titulo).append("\n");
		sb.append("Preço: R$").append(preco).append("\n");
		sb.append("Autores:").append("\n");
		for (Autor autor : autores) {
			sb.append("- ").append(autor.getNomeCompleto()).append("\n");
		}
		return sb.toString();
	}

	public void adicionarAutor(Autor autorSelecionado) {
		autores.add(autorSelecionado);
		
	}

}
