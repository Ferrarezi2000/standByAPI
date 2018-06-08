package com.standby.builder;

import com.standby.dto.ServicoDTO;
import com.standby.model.Cliente;
import com.standby.model.Servico;
import com.standby.repository.ClienteRepository;
import com.standby.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServicoBuilder {

    @Autowired private ServicoRepository repository;
    @Autowired private ClienteRepository clienteRepository;

    public Servico build(Servico servico, ServicoDTO dto) {

        Cliente cliente = clienteRepository.findOne(dto.getClienteId());

        servico.setCliente(cliente);
        servico.setDataSolicitacao(new Date());
        servico.setDescricao(dto.getDescricao());
        servico.setValor(dto.getValor());

        if (dto.getStatus() == null) {
            servico.setStatus("EM ANÁLISE");
        } else {
            servico.setStatus(dto.getStatus());
        }

        if (dto.getCancelado() == null) {
            servico.setCancelado(false);
        } else {
            servico.setCancelado(dto.getCancelado());
        }

        if (dto.getPago() == null) {
            servico.setPago(false);
        } else {
            servico.setPago(dto.getPago());
        }

        servico.setMotivoCancelamento(dto.getMotivoCancelamento());

        repository.save(servico);

        return servico;
    }
}
