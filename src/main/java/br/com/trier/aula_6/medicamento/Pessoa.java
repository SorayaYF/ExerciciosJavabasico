package br.com.trier.aula_6.medicamento;

import java.util.List;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Pessoa {
	private String nome;
	private String sintoma;
	private List<String> alergias;
	private List<Medicamento> medicamentos;

	public Pessoa(String nome, String sintoma, List<String> alergias) {
		this.nome = nome;
		this.sintoma = sintoma;
		this.alergias = alergias;
		this.medicamentos = new ArrayList<>();
	}

	public void adicionarMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}

	public boolean possuiAlergia(Medicamento medicamento) {
		for (String alergia : alergias) {
			if (medicamento.getAlergias().contains(alergia)) {
				return true;
			}
		}
		return false;
	}

}
