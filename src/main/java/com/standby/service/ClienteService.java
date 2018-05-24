package com.standby.service;

import com.standby.model.Cliente;
import com.standby.model.Contato;
import com.standby.model.Endereco;
import com.standby.repository.ClienteRepository;
import com.standby.repository.ContatoRepository;
import com.standby.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired private ClienteRepository clienteRepository;
    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private ContatoRepository contatoRepository;

    public Cliente busca(Cliente cliente) {
        List<Contato> contatos = contatoRepository.findAllByCliente(cliente);
        Endereco endereco = enderecoRepository.findTopByCliente(cliente);

        cliente.setContatos(contatos);
        cliente.setEndereco(endereco);

        return cliente;
    }

    public List<Cliente> completo() {
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            Endereco endereco = enderecoRepository.findTopByCliente(cliente);
            cliente.setEnderecoBairro(endereco.getBairro());
            cliente.setEnderecoLogradouro(endereco.getLogradouro());
            cliente.setEnderecoNumero(endereco.getNumero());
            cliente.setEnderecoCidade(endereco.getCidade());

            Contato contato = contatoRepository.findTopByCliente(cliente);
            cliente.setContatoNumero(contato.getNumero());
        });

        return clientes;
    }
}
