package br.com.trier.aula_3.livros;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CadastroLivro {
	public void cadastrarLivro(List<Livro> livros, List<Autor> autores) {
        String titulo;
        double preco;

        do {
            titulo = JOptionPane.showInputDialog("Digite o título do livro:");

            if (titulo == null) {
                return;
            }

        } while (titulo.isEmpty());
        titulo = titulo.toLowerCase();
        
        do {
        	String digitaPreco = JOptionPane.showInputDialog("Digite o preço do livro:");
			if (digitaPreco == null) {
				return;
			}
			try {
				preco = Double.parseDouble(digitaPreco);
				if (preco <= 0) {
					JOptionPane.showMessageDialog(null, "Preço inválido. Cadastro cancelado.");
					return;
				}
				break;
			} catch (NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Preço inválido. Digite novamente.");
			}
		} while (true);

        Livro livro = new Livro(titulo, preco);
        List<Autor> autoresSelecionados = new ArrayList<Autor>();
        
        do {
            String[] opcoesAutores = new String[autores.size()];
            for (int i = 0; i < autores.size(); i++) {
                Autor autor = autores.get(i);
                opcoesAutores[i] = autor.getNome() + " " + autor.getSobrenome();
            }

            Object selecionaAutor = JOptionPane.showInputDialog(null, "Selecione o autor do livro:", "Autor",
                    JOptionPane.PLAIN_MESSAGE, null, opcoesAutores, opcoesAutores[0]);

            if (selecionaAutor == null) {
                break;
            }

            Autor autorSelecionado = null;
            for (Autor autor : autores) {
                if ((autor.getNome() + " " + autor.getSobrenome()).equals(selecionaAutor)) {
                    autorSelecionado = autor;
                    break;
                }
            }

            if (autorSelecionado != null) {
                if (autoresSelecionados.size() < 4) {
                    autoresSelecionados.add(autorSelecionado);
                    livro.adicionarAutor(autorSelecionado);
                } else {
                    JOptionPane.showMessageDialog(null, "O livro já possui o número máximo de autores (4).");
                }
            }

            Object[] options = { "Sim", "Não" };
            int op = JOptionPane.showOptionDialog(null, "Deseja adicionar mais um autor para este livro?", "Adicionar Autor", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (op == JOptionPane.NO_OPTION) {
                break;
            }
        } while (true);



        livros.add(livro);

        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }



}
