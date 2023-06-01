package br.com.trier.aula_7.farmacia.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_7.farmacia.models.Cliente;
import br.com.trier.aula_7.farmacia.models.Medicamento;
import br.com.trier.aula_7.farmacia.models.Perfumaria;
import br.com.trier.aula_7.farmacia.models.Produto;
import br.com.trier.aula_7.farmacia.models.ProdutoHospitalar;

public class Farmacia {
	private List<Produto> produtos;
	private List<Cliente> clientes;

	public Farmacia() {
		this.produtos = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public void cadastrarProduto(Produto produto) {
		produtos.add(produto);
	}

	public void cadastrarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public boolean realizarVenda(Cliente cliente, Produto produto, int quantidade, String nomeMedico) {
		if (produto instanceof Medicamento) {
			Medicamento medicamento = (Medicamento) produto;
			if (!medicamento.isReceitaObrigatoria() || nomeMedico != null) {
				if (medicamento.getEstoque() >= quantidade) {
					double valorVenda = produto.getValor() * quantidade;
					cliente.incrementarSaldoDevedor(valorVenda);
					medicamento.decrementarEstoque(quantidade);
					return true;
				}
			}
		} else if (produto instanceof Perfumaria) {
			Perfumaria perfumaria = (Perfumaria) produto;
			if (cliente.getSaldoDevedor() < 300.0 && perfumaria.getEstoque() >= quantidade) {
				double valorVenda = produto.getValor() * quantidade;
				cliente.incrementarSaldoDevedor(valorVenda);
				perfumaria.decrementarEstoque(quantidade);
				return true;
			}
		} else if (produto instanceof ProdutoHospitalar) {
			double valorVenda = produto.getValor() * quantidade;
			cliente.incrementarSaldoDevedor(valorVenda);
			return true;
		}
		return false;
	}

	public void realizarPagamento(Cliente cliente, double valorPagamento) {
		cliente.decrementarSaldoDevedor(valorPagamento);
	}

	public List<Produto> consultarProdutosEmEstoque() {
		List<Produto> produtosEmEstoque = new ArrayList<>();
		for (Produto produto : produtos) {
			if (produto.getEstoque() > 0) {
				produtosEmEstoque.add(produto);
			}
		}
		return produtosEmEstoque;
	}

	public List<Cliente> consultarClientesComDivida() {
		List<Cliente> clientesComDivida = new ArrayList<>();
		for (Cliente cliente : clientes) {
			if (cliente.getSaldoDevedor() > 0.0) {
				clientesComDivida.add(cliente);
			}
		}
		return clientesComDivida;
	}
}
