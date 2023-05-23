package br.com.trier.aula_2.carros;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class CarroController {
    private List<Carro> carros = new ArrayList<Carro>();

    public void cadastrarCarro() {
    	String marca;
    	int ano;
    	CorCarro corCarro;
    	do {
    		marca = JOptionPane.showInputDialog("Digite a marca do carro:");
       
        if (marca == null) {
        	return;
        }
        
    	} while(marca.isEmpty());
    	
    	do {
    		 String digitaAno = JOptionPane.showInputDialog("Digite o ano do carro:");
    		 if (digitaAno == null) {
    	        	return;
    	        }
    		 try {
    			 ano = Integer.parseInt(digitaAno);
    			 break;
    		 } catch (NumberFormatException e) {
    			 JOptionPane.showMessageDialog(null, "Ano inválido. Digite novamente.");
    		 }
    	} while(true);

        Object [] cores = CorCarro.values();
        corCarro = (CorCarro) JOptionPane.showInputDialog(
            null,
            "Escolha a cor do carro:",
            "Cor",
            JOptionPane.QUESTION_MESSAGE,
            null,
            cores,
            cores[0]
        );
        if (corCarro == null) {
        	return;
        }

        Carro carro = new Carro(marca, ano, corCarro);
        carros.add(carro);

        JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
    }

    public void listarCarrosPorPeriodo() {
        String anoInicialStr = JOptionPane.showInputDialog("Digite o ano inicial:");
        if (anoInicialStr == null) {
        	return;
        }
        int anoInicial = Integer.parseInt(anoInicialStr);

        String anoFinalStr = JOptionPane.showInputDialog("Digite o ano final:");
        if (anoFinalStr == null) {
        	return;
        }
        int anoFinal = Integer.parseInt(anoFinalStr);

        List<Carro> carrosPorPeriodo = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.getAno() >= anoInicial && carro.getAno() <= anoFinal) {
                carrosPorPeriodo.add(carro);
            }
        }

        exibirCarros(carrosPorPeriodo);
    }

    public void listarCarrosPorMarca() {
        String marca = JOptionPane.showInputDialog("Digite a marca:");
        if (marca == null) {
        	return;
        }
        marca = marca.toUpperCase();

        List<Carro> carrosPorMarca = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.getMarca().equalsIgnoreCase(marca)) {
                carrosPorMarca.add(carro);
            }
        }

        exibirCarros(carrosPorMarca);
    }

    public void listarCarrosPorCor() {
        Object[] cores = CorCarro.values();
        CorCarro corCarro = (CorCarro) JOptionPane.showInputDialog(
            null,
            "Escolha a cor:",
            "Cor",
            JOptionPane.QUESTION_MESSAGE,
            null,
            cores,
            cores[0]
        );
        if (corCarro == null) {
        	return;
        }

        List<Carro> carrosPorCor = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.getCorCarro() == corCarro) {
                carrosPorCor.add(carro);
            }
        }

        exibirCarros(carrosPorCor);
    }

    private void exibirCarros(List<Carro> carros) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Carros encontrados: ").append(carros.size()).append("\n\n");

        for (Carro carro : carros) {
            mensagem.append("Marca: ").append(carro.getMarca()).append("\n");
            mensagem.append("Ano: ").append(carro.getAno()).append("\n");
            mensagem.append("Cor: ").append(carro.getCorCarro()).append("\n\n");
        }

        double percentual = (double) carros.size() / this.carros.size() * 100;
        mensagem.append(String.format("Percentual: %.2f%%", percentual));

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
}



