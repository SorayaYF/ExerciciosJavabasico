package br.com.trier.aula_2.carros;

public class Carro {
	private String marca;
    private int ano;
    private CorCarro corCarro;

    public Carro(String marca, int ano, CorCarro corCarro) {
        this.marca = marca;
        this.ano = ano;
        this.corCarro = corCarro;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

	public CorCarro getCorCarro() {
		return corCarro;
	} 


}
