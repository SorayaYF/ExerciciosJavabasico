package br.com.trier.aula_6.faculdade.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import br.com.trier.aula_6.faculdade.enums.Formacao;

@Getter
@RequiredArgsConstructor
public class Professor {

	@NonNull
	private String nome;
	@NonNull
	private Formacao formacao;

}
