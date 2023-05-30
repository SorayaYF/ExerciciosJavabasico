package br.com.trier.aula_6.faculdade.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Aluno {
    @NonNull
    private String nome;
    private Map<Disciplina, List<Double>> notasDisciplinas = new HashMap<>();

    public void adicionarDisciplina(Disciplina disciplina) {
        notasDisciplinas.put(disciplina, new ArrayList<>());
    }

    public void adicionarNota(Disciplina disciplina, double nota) {
        List<Double> notas = notasDisciplinas.get(disciplina);
        notas.add(nota);
    }

    public double calcularMedia(Disciplina disciplina) {
        List<Double> notas = notasDisciplinas.get(disciplina);
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return new ArrayList<>(notasDisciplinas.keySet());
    }
}
