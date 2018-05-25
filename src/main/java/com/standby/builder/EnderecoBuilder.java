package com.standby.builder;

import com.standby.dto.EnderecoDTO;
import com.standby.model.Cliente;
import com.standby.model.Endereco;
import com.standby.repository.ClienteRepository;
import com.standby.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoBuilder {

    @Autowired private EnderecoRepository repository;
    @Autowired private ClienteRepository clienteRepository;

    public Endereco build(Endereco endereco, EnderecoDTO dto) {

        Cliente cliente = clienteRepository.findOne(dto.getClienteId());

        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setCliente(cliente);

        repository.save(endereco);

        return endereco;
    }
}
