package br.com.trier.aula_6.exercicio_medicamento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Administracao {
	
	ORAL ("Oral"),
	INJETAVEL("Injetável"),
	TOPICO ("Tópico"),
	SUPOSITORIO ("Supositório");
	
	private String descricao;

}
