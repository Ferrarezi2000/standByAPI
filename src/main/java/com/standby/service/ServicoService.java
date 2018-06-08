package com.standby.service;

import com.standby.model.Contato;
import com.standby.model.Endereco;
import com.standby.model.Servico;
import com.standby.repository.ContatoRepository;
import com.standby.repository.EnderecoRepository;
import com.standby.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired private ServicoRepository servicoRepository;
    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private ContatoRepository contatoRepository;

    public List<Servico> listaCompleta() {
        List<Servico> servicos = servicoRepository.findAll();
        servicos.forEach(item -> {
            List<Contato> contatos = contatoRepository.findAllByCliente(item.getCliente());
            item.getCliente().setContatos(contatos);

            Endereco endereco = enderecoRepository.findTopByCliente(item.getCliente());
            item.getCliente().setEndereco(endereco);
        });

        return servicos;
    }

    public List<Servico> receber () {
        List<Servico> servicos = servicoRepository.findAllByPagoAndStatus(false, "CONCLUÍDO");

        return servicos;
    }

}
