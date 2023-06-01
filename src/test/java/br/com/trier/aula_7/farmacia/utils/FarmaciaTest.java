package br.com.trier.aula_7.farmacia.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_7.farmacia.models.Cliente;
import br.com.trier.aula_7.farmacia.models.Medicamento;
import br.com.trier.aula_7.farmacia.models.Perfumaria;
import br.com.trier.aula_7.farmacia.models.Produto;
import br.com.trier.aula_7.farmacia.models.ProdutoHospitalar;

class FarmaciaTest {
	
    private Farmacia farmacia;
    private Cliente cliente1;
    private Cliente cliente2;
    private Produto medicamento;
    private Produto perfumaria;
    private Produto produtoHospitalar;

    @BeforeEach
    void setUp() {
        farmacia = new Farmacia();

        medicamento = new Medicamento("Paracetamol", 50, 5.0, false);
        perfumaria = new Perfumaria("Perfume Importado", 10, 100.0);
        produtoHospitalar = new ProdutoHospitalar("Luvas Descartáveis", 2.0);

        farmacia.cadastrarProduto(medicamento);
        farmacia.cadastrarProduto(perfumaria);
        farmacia.cadastrarProduto(produtoHospitalar);

        cliente1 = new Cliente("João");
        cliente2 = new Cliente("Maria");

        farmacia.cadastrarCliente(cliente1);
        farmacia.cadastrarCliente(cliente2);
    }

    @Test
    @DisplayName("Teste realizar venda de medicamento com estoque suficiente")
    void testRealizarVendaMedicamentoEstoqueSuficiente() {
        boolean venda = farmacia.realizarVenda(cliente1, medicamento, 3, null);
        assertTrue(venda);
        assertEquals(3, medicamento.getEstoque());
        assertEquals(15.0, cliente1.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar venda de medicamento com estoque insuficiente")
    void testRealizarVendaMedicamentoEstoqueInsuficiente() {
        boolean venda = farmacia.realizarVenda(cliente1, medicamento, 60, null);
        assertFalse(venda);
        assertEquals(50, medicamento.getEstoque());
        assertEquals(0.0, cliente1.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar venda de perfumaria com saldo devedor abaixo de 300")
    void testRealizarVendaPerfumariaSaldoDevedorAbaixo300() {
        boolean venda = farmacia.realizarVenda(cliente1, perfumaria, 2, null);
        assertTrue(venda);
        assertEquals(8, perfumaria.getEstoque());
        assertEquals(200.0, cliente1.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar venda de perfumaria com saldo devedor acima de 300")
    void testRealizarVendaPerfumariaSaldoDevedorAcima300() {
        cliente2.incrementarSaldoDevedor(500.0);
        boolean venda = farmacia.realizarVenda(cliente2, perfumaria, 1, null);
        assertFalse(venda);
        assertEquals(10, perfumaria.getEstoque());
        assertEquals(500.0, cliente2.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar venda de produto hospitalar")
    void testRealizarVendaProdutoHospitalar() {
        boolean venda = farmacia.realizarVenda(cliente1, produtoHospitalar, 10, null);
        assertTrue(venda);
        assertEquals(0, produtoHospitalar.getEstoque());
        assertEquals(20.0, cliente1.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar venda de medicamento com retenção de receita")
    void testRealizarVendaMedicamentoComRetencaoReceita() {
        boolean venda = farmacia.realizarVenda(cliente1, medicamento, 1, "Dr. Carlos");
        assertTrue(venda);
        assertEquals(49, medicamento.getEstoque());
        assertEquals(5.0, cliente1.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar pagamento parcial da conta")
    void testRealizarPagamentoParcial() {
        cliente1.incrementarSaldoDevedor(50.0);
        double saldoDevedorAnterior = cliente1.getSaldoDevedor();
        double valorPago = 30.0;
        farmacia.realizarPagamento(cliente1, valorPago);
        assertEquals(saldoDevedorAnterior - valorPago, cliente1.getSaldoDevedor());
    }

    @Test
    @DisplayName("Teste realizar pagamento total da conta")
    void testRealizarPagamentoTotal() {
        cliente1.incrementarSaldoDevedor(100.0);
        farmacia.realizarPagamento(cliente1, 100.0);
        assertEquals(0.0, cliente1.getSaldoDevedor());
    }
}
