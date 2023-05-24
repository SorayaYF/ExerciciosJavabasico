package br.com.trier.aula_3.times;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Controller {

	private List<Time> times;

	public Controller() {
		this.times = new ArrayList<Time>();
	}

	public void cadastrarTime() {
		String nomeTime;
		do {
			nomeTime = JOptionPane.showInputDialog("Digite o nome do time:");

			if (nomeTime == null) {
				return;
			}

		} while (nomeTime.isEmpty());

		Time time = new Time(nomeTime);
		cadastrarJogadores(time);
		times.add(time);

		JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
	}
	
	private boolean numeroCamisaJaUtilizado(Time time, int numeroCamisa) {
		for(Jogador jogador : time.getJogadores()) {
			if(jogador.getNumeroCamisa() == numeroCamisa) {
				return true;
			}
		}
		return false;
	}

	private void cadastrarJogadores(Time time) {
		String nomeJogador;
		int numeroCamisa;
		int golsMarcados;
		do {
			nomeJogador = JOptionPane.showInputDialog("Digite o nome do jogador:");

			if (nomeJogador == null) {
				return;
			}

		} while (nomeJogador.isEmpty());
		do {
			String digitaNumeroCamisa = JOptionPane.showInputDialog("Digite o número da camisa do jogador:");
			if (digitaNumeroCamisa == null) {
				return;
			}
			try {
				numeroCamisa = Integer.parseInt(digitaNumeroCamisa);
				if(!numeroCamisaJaUtilizado(time, numeroCamisa)) {
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Número já utilizado, digite novamente.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Número inválido. Digite novamente.");
			}
		} while (true);
		
		do {
			String digitaGolsMarcados = JOptionPane.showInputDialog("Digite a quantidade de gols marcados pelo jogador:");
			if (digitaGolsMarcados == null) {
				return;
			}
			try {
				golsMarcados = Integer.parseInt(digitaGolsMarcados);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Número inválido. Digite novamente.");
			}
		} while (true);
		Jogador jogador = new Jogador(nomeJogador, numeroCamisa, golsMarcados);
		time.adicionarJogador(jogador);
		
		Object[] options = { "Sim", "Não" };
		
		int op = JOptionPane.showOptionDialog(null, "Deseja adicionar outro jogador?", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(op == JOptionPane.YES_OPTION) {
			cadastrarJogadores(time);
		}
	}

	public void listarJogadoresTime() {
		if (times.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum time cadastrado.");
			return;
		}

		String[] opcoesTimes = new String[times.size()];
		for (int i = 0; i < times.size(); i++) {
			opcoesTimes[i] = times.get(i).getNome();
		}

		String nomeTime = (String) JOptionPane.showInputDialog(null, "Selecione o time:", "Listar jogadores de um time",
				JOptionPane.QUESTION_MESSAGE, null, opcoesTimes, opcoesTimes[0]);

		if (nomeTime == null || nomeTime.isEmpty())
			return;

		Time time = buscarTimePorNome(nomeTime);
		if (time == null) {
			JOptionPane.showMessageDialog(null, "Time não encontrado.");
			return;
		}

		List<Jogador> jogadores = time.getJogadores();
		StringBuilder mensagem = new StringBuilder("Jogadores do time " + time.getNome() + ":\n");
		for (Jogador jogador : jogadores) {
			mensagem.append("Nome: ").append(jogador.getNome()).append(", Número da Camisa: ")
					.append(jogador.getNumeroCamisa()).append(", Gols Marcados: ").append(jogador.getGolsMarcados())
					.append("\n");
		}
		JOptionPane.showMessageDialog(null, mensagem.toString());
	}

	public void verificarArtilheiro() {
		if (times.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum time cadastrado.");
			return;
		}

		Jogador artilheiro = null;
		int maxGols = 0;
		for (Time time : times) {
			Jogador jogador = time.getArtilheiro();
			if (jogador != null && jogador.getGolsMarcados() > maxGols) {
				artilheiro = jogador;
				maxGols = jogador.getGolsMarcados();
			}
		}

		if (artilheiro == null) {
			JOptionPane.showMessageDialog(null, "Nenhum jogador marcou gols no campeonato.");
		} else {
			JOptionPane.showMessageDialog(null,
					"Artilheiro do campeonato:\n" + "Nome: " + artilheiro.getNome() + "\n" + "Time: "
							+ buscarTimeDoJogador(artilheiro).getNome() + "\n" + "Gols Marcados: "
							+ artilheiro.getGolsMarcados());
		}
	}

	public void verificarTimeMaisGols() {
		if (times.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum time cadastrado.");
			return;
		}

		Time timeMaisGols = null;
		int maxGols = 0;
		for (Time time : times) {
			int totalGols = time.getTotalGols();
			if (totalGols > maxGols) {
				timeMaisGols = time;
				maxGols = totalGols;
			}
		}

		if (timeMaisGols == null) {
			JOptionPane.showMessageDialog(null, "Nenhum time marcou gols no campeonato.");
		} else {
			JOptionPane.showMessageDialog(null, "Time com mais gols no campeonato:\n" + "Time: "
					+ timeMaisGols.getNome() + "\n" + "Total de Gols: " + maxGols);
		}
	}

	private Time buscarTimePorNome(String nomeTime) {
		for (Time time : times) {
			if (time.getNome().equalsIgnoreCase(nomeTime)) {
				return time;
			}
		}
		return null;
	}

	private Time buscarTimeDoJogador(Jogador jogador) {
		for (Time time : times) {
			List<Jogador> jogadores = time.getJogadores();
			if (jogadores.contains(jogador)) {
				return time;
			}
		}
		return null;
	}
}
