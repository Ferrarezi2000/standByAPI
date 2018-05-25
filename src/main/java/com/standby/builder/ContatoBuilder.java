package com.standby.builder;

import com.standby.dto.ContatoDTO;
import com.standby.model.Cliente;
import com.standby.model.Contato;
import com.standby.repository.ClienteRepository;
import com.standby.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContatoBuilder {

    @Autowired private ContatoRepository repository;
    @Autowired private ClienteRepository clienteRepository;

    public Contato build(Contato contato, ContatoDTO dto) {

        Cliente cliente = clienteRepository.findOne(dto.getClienteId());

        contato.setNumero(dto.getNumero());
        if (dto.getFalarCom() == null) {
            contato.setFalarCom(cliente.getNome());
        } else {
            contato.setFalarCom(dto.getFalarCom());
        }
        contato.setCliente(cliente);

        repository.save(contato);

        return contato;
    }
}
