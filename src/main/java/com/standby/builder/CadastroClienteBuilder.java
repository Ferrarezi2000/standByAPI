package com.standby.builder;

import com.standby.dto.ObjetoDTO;
import com.standby.model.Cliente;
import com.standby.model.Contato;
import com.standby.model.Endereco;
import com.standby.repository.ClienteRepository;
import com.standby.repository.ContatoRepository;
import com.standby.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroClienteBuilder {

    @Autowired private ClienteRepository clienteRepository;
    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private ContatoRepository contatoRepository;

    public Cliente build(ObjetoDTO objetoDTO) {

        Cliente cliente = new Cliente();
        cliente.setNome(objetoDTO.getClienteDTO().getNome());
        cliente.setSobrenome(objetoDTO.getClienteDTO().getSobrenome());
        cliente.setCpf(objetoDTO.getClienteDTO().getCpf());
        cliente.setDataNascimento(objetoDTO.getClienteDTO().getDataNascimento());
        clienteRepository.save(cliente);

        Endereco endereco = new Endereco();
        endereco.setNumero(objetoDTO.getEnderecoDTO().getNumero());
        endereco.setLogradouro(objetoDTO.getEnderecoDTO().getLogradouro());
        endereco.setBairro(objetoDTO.getEnderecoDTO().getBairro());
        endereco.setCidade(objetoDTO.getEnderecoDTO().getCidade());
        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);

        Contato contato = new Contato();
        contato.setNumero(objetoDTO.getContatoDTO().getNumero());
        if (objetoDTO.getContatoDTO().getFalarCom() == null) {
            contato.setFalarCom(objetoDTO.getClienteDTO().getNome());
        } else {
            contato.setFalarCom(objetoDTO.getContatoDTO().getFalarCom());
        }

        contato.setCliente(cliente);
        contatoRepository.save(contato);

        return cliente;

    }
}
