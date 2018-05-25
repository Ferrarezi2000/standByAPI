package com.standby.service;

import com.standby.dto.AdministradorDTO;
import com.standby.model.Administrador;
import com.standby.model.Cliente;
import com.standby.model.Contato;
import com.standby.model.Endereco;
import com.standby.repository.AdministradorRepository;
import com.standby.repository.ClienteRepository;
import com.standby.repository.ContatoRepository;
import com.standby.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired private AdministradorRepository repository;

    public Administrador logar(AdministradorDTO dto) {
        Administrador administrador = repository.findByEmailAndSenha(dto.getEmail(), dto.getSenha());

        return administrador;
    }
}
