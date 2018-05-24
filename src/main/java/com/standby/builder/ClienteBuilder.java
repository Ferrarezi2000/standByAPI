package com.standby.builder;

import com.standby.dto.ClienteDTO;
import com.standby.model.Cliente;
import com.standby.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteBuilder {

    @Autowired private ClienteRepository repository;

    public Cliente build(Cliente cliente, ClienteDTO dto) {

        cliente.setNome(dto.getNome());
        cliente.setSobrenome(dto.getSobrenome());
        cliente.setCpf(dto.getCpf());

        repository.save(cliente);

        return cliente;
    }
}
