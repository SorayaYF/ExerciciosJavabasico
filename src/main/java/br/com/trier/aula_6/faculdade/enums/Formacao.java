package br.com.trier.aula_6.faculdade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Formacao {

	GRADUACAO("Graduação"),
	ESPECIALIZACAO("Especialização"),
	POS_GRADUACAO("Pós-Graduação");

	private String descricao;

}
