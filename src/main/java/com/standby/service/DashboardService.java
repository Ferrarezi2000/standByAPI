package com.standby.service;

import com.standby.model.*;
import com.standby.model.abstrato.MapBuilder;
import com.standby.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired private ServicoRepository servicoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private DespesaRepository despesaRepository;
    @Autowired private VendaRepository vendaRepository;
    @Autowired private SaqueRepository saqueRepository;

    public Map servicos() {
        List<Servico> servicosAnalise = servicoRepository.findAllByStatus("EM ANÁLISE");
        List<Servico> servicosConcluido = servicoRepository.findAllByStatus("CONCLUÍDO");
        List<Servico> servicosCancelado = servicoRepository.findAllByStatus("CANCELADO");
        List<Servico> recebido = servicoRepository.findAllByPago(true);
        List<Servico> faltaReceber = servicoRepository.findAllByPagoAndStatus(false, "CONCLUÍDO");
        List<Venda> vendas = vendaRepository.findAllBySacado(false);
        List<Saque> saques = saqueRepository.findAll();

        BigDecimal valorTotalVendas = vendas.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal totalRecebido = recebido.stream().map(item->item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal totalFaltaReceber = faltaReceber.stream().map(item->item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal totalSaques = saques.stream().map(item->item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add);

        List<Cliente> clientes = clienteRepository.findAll();

        List<Despesa> despesas = despesaRepository.findAllByPago(false);

        BigDecimal totalDespesas = despesas.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);

        Map retorno = MapBuilder.build()
                .add("totalValorSaques", totalSaques)
                .add("todasVendas", vendas.size())
                .add("todosServicosRecebidos", recebido.size())
                .add("valorTotalVendas", valorTotalVendas)
                .add("totalDespesas", totalDespesas)
                .add("totalClientes", clientes.size())
                .add("valorTotalRecebido", totalRecebido)
                .add("valorTotalFaltaReceber", totalFaltaReceber)
                .add("totalServicosAnalise", servicosAnalise.size())
                .add("totalServicosConcluido", servicosConcluido.size())
                .add("totalServicosCancelado", servicosCancelado.size());

        return retorno;

    }

}
