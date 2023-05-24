package br.com.trier.aula_3.times;

import java.util.List;
import java.util.ArrayList;

import lombok.Getter;

@Getter

public class Time {
	private String nome;
	private List<Jogador> jogadores;

	public Time(String nome) {
		this.nome = nome;
		this.jogadores = new ArrayList<Jogador>();
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	public int getTotalGols() {
		int totalGols = 0;
		for (Jogador jogador : jogadores) {
			totalGols += jogador.getGolsMarcados();
		}
		return totalGols;
	}

	public Jogador getArtilheiro() {
		Jogador artilheiro = null;
		int maxGols = 0;
		for (Jogador jogador : jogadores) {
			if (jogador.getGolsMarcados() > maxGols) {
				artilheiro = jogador;
				maxGols = jogador.getGolsMarcados();
			}
		}
		return artilheiro;
	}
}
