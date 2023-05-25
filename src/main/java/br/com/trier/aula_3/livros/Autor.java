package br.com.trier.aula_3.livros;

import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Autor {

	private String nome;
	private String sobrenome;
	private Sexo sexo;
	private int idade;

	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}
	
	public static List<String> getNomesAutores(List<Autor> autores) {
        List<String> nomes = new ArrayList<String>();
        for (Autor autor : autores) {
            nomes.add(autor.getNome() + " " + autor.getSobrenome());
        }
        return nomes;
    }


}
