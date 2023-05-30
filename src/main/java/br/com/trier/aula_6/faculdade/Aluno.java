package br.com.trier.aula_6.faculdade;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;

@Getter

public class Aluno {

	private String nome;
    private List<Disciplina> disciplinas;
    private List<List<Double>> notas;
    
    public Aluno(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
        this.notas = new ArrayList<List<Double>>();
    }

    
    public void matricularDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        notas.addAll((Collection<? extends List<Double>>) new ArrayList<Object>());
    }
    
    public void informarNotas(Disciplina disciplina, List<Double> notas) {
        int index = disciplinas.indexOf(disciplina);
        if (index != -1) {
            this.notas.set(index, notas);
        }
    }

    public double calcularMedia(Disciplina disciplina) {
        int index = disciplinas.indexOf(disciplina);
        if (index != -1) {
            List<Double> notasDisciplina = this.notas.get(index);
            double soma = notasDisciplina.stream().mapToDouble(Double::doubleValue).sum();
            return soma / notasDisciplina.size();
        }
        return 0.0;
    }

    public List<Disciplina> getDisciplinasComMedia() {
        List<Disciplina> disciplinasComMedia = new ArrayList<Disciplina>();
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = disciplinas.get(i);
            double media = calcularMedia(disciplina);
            disciplinasComMedia.add(disciplina);
        }
        return disciplinasComMedia;
    }



}
