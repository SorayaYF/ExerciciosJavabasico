package br.com.trier.aula_6.faculdade;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Disciplina {

	private String nome;
	private int cargaHoraria;
	private Professor professor;

}
