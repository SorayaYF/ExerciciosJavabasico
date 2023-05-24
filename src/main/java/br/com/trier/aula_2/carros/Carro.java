package br.com.trier.aula_2.carros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Carro {
	private String marca;
    private int ano;
    private CorCarro corCarro;

    public Carro(String marca, int ano, CorCarro corCarro) {
        this.marca = marca;
        this.ano = ano;
        this.corCarro = corCarro;
    }
}
