package com.standby.service;

import com.standby.model.Cliente;
import com.standby.model.Despesa;
import com.standby.model.Servico;
import com.standby.model.abstrato.MapBuilder;
import com.standby.repository.ClienteRepository;
import com.standby.repository.DespesaRepository;
import com.standby.repository.ServicoRepository;
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

    public Map servicos() {
        List<Servico> servicosAnalise = servicoRepository.findAllByStatus("EM ANÁLISE");
        List<Servico> servicosConcluido = servicoRepository.findAllByStatus("CONCLUÍDO");
        List<Servico> servicosCancelado = servicoRepository.findAllByStatus("CANCELADO");
        List<Servico> recebido = servicoRepository.findAllByPago(true);
        List<Servico> faltaReceber = servicoRepository.findAllByPagoAndStatus(false, "CONCLUÍDO");

        BigDecimal totalRecebido = recebido.stream().map(item->item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal totalFaltaReceber = faltaReceber.stream().map(item->item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add);

        List<Cliente> clientes = clienteRepository.findAll();

        List<Despesa> despesas = despesaRepository.findAllByPago(false);

        BigDecimal totalDespesas = despesas.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);

        Map retorno = MapBuilder.build()
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
