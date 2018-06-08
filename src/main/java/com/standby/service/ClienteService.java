package com.standby.service;

import com.standby.model.Cliente;
import com.standby.model.Contato;
import com.standby.model.Endereco;
import com.standby.model.Servico;
import com.standby.repository.ClienteRepository;
import com.standby.repository.ContatoRepository;
import com.standby.repository.EnderecoRepository;
import com.standby.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired private ClienteRepository clienteRepository;
    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private ContatoRepository contatoRepository;
    @Autowired private ServicoRepository servicoRepository;

    public Cliente busca(Cliente cliente) {
        List<Contato> contatos = contatoRepository.findAllByCliente(cliente);
        Endereco endereco = enderecoRepository.findTopByCliente(cliente);
        List<Servico> servicos = servicoRepository.findByCliente(cliente);

        servicos.forEach(item -> item.setCliente(null));

        cliente.setServicos(servicos);
        cliente.setContatos(contatos);
        cliente.setEndereco(endereco);

        return cliente;
    }

    public List<Cliente> completo() {
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            List<Contato> contatos = contatoRepository.findAllByCliente(cliente);
            Endereco endereco = enderecoRepository.findTopByCliente(cliente);

            cliente.setContatos(contatos);
            cliente.setEndereco(endereco);
        });

        return clientes;
    }
}
