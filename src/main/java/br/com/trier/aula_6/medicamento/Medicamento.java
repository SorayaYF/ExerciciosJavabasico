package br.com.trier.aula_6.medicamento;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Medicamento {
	
	private String nome;
	
	private EnumAdministracao administracao;
	
    private List<String> alergiasContraindicadas;
    
    private List<String> indicacoes;

}
