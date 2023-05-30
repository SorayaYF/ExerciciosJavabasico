package br.com.trier.aula_6.exercicio_medicamento.models;

import br.com.trier.aula_6.exercicio_medicamento.enums.Administracao;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Getter
@RequiredArgsConstructor
public class Medicamento {
	
	@NonNull
	private String nome;
	@NonNull
	private Administracao administracao;
	private List<String> contraIndicacoes = new ArrayList<String>();
	private List<String> indicacoes = new ArrayList<String>();
	
	public boolean isIndicado(String sintoma) {
		return indicacoes.contains(sintoma);
	}
	
	public boolean isContraIndicado(List<String> condicaoSaude) {
		return condicaoSaude.stream()
				.anyMatch(contraIndicacoes :: contains);
	}
	
	public void addIndicacao(String indicacao) {
		indicacoes.add(indicacao);
	}
	
	public void addContraIndicacao(String contraIndicacao) {
		contraIndicacoes.add(contraIndicacao);
	}
}
