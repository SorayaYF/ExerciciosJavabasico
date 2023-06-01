package br.com.trier.aula_7.farmacia.models;

public class Medicamento extends Produto{
	
	private boolean receitaObrigatoria;
	
    public Medicamento(String nome, int estoque, double valor, boolean receitaObrigatoria) {
        super(nome, estoque, valor);
        this.receitaObrigatoria = receitaObrigatoria;
    }

    public boolean isReceitaObrigatoria() {
        return receitaObrigatoria;
    }
}
