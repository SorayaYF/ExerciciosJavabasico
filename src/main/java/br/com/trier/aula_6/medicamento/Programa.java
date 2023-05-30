package br.com.trier.aula_6.medicamento;

import java.util.List;
import java.util.ArrayList;

public class Programa {
    private List<Medicamento> medicamentos;
    private List<Pessoa> pessoas;

    public Programa() {
        medicamentos = new ArrayList<>();
        pessoas = new ArrayList<>();
    }

    public void cadastrarMedicamento(String nome, EnumAdministracao administracao, List<String> alergias, List<String> indicacoes) {
        Medicamento medicamento = new Medicamento(nome, administracao, alergias, indicacoes);
        medicamentos.add(medicamento);
    }

    public void cadastrarPessoa(String nome, String sintoma, List<String> alergias) {
        Pessoa pessoa = new Pessoa(nome, sintoma, alergias);
        pessoas.add(pessoa);
    }

    public void prescreverMedicamento(String pessoaNome, String medicamentoNome) {
        Pessoa pessoa = null;
        Medicamento medicamento = null;

        for (Pessoa p : pessoas) {
            if (p.getNome().equals(pessoaNome)) {
                pessoa = p;
                break;
            }
        }

        for (Medicamento m : medicamentos) {
            if (m.getNome().equals(medicamentoNome)) {
                medicamento = m;
                break;
            }
        }

        if (pessoa != null && medicamento != null) {
            if (medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
                if (!pessoa.possuiAlergia(medicamento)) {
                    pessoa.adicionarMedicamento(medicamento);
                    System.out.println("Medicamento prescrito com sucesso!");
                } else {
                    System.out.println("A pessoa possui alergia ao medicamento!");
                }
            } else {
                System.out.println("O medicamento não é indicado para o sintoma da pessoa!");
            }
        } else {
            System.out.println("Pessoa ou medicamento não encontrados!");
        }
    }

    public void listarPessoasEMedicamentos() {
        for (Pessoa pessoa : pessoas) {
            System.out.println("Pessoa: " + pessoa.getNome());
            System.out.println("Medicamentos prescritos:");
            for (Medicamento medicamento : pessoa.getMedicamentos()) {
                System.out.println("- " + medicamento.getNome());
            }
            System.out.println();
        }
    }
}