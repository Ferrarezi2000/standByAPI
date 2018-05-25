package com.standby.builder;

import com.standby.dto.AdministradorDTO;
import com.standby.dto.ClienteDTO;
import com.standby.model.Administrador;
import com.standby.model.Cliente;
import com.standby.repository.AdministradorRepository;
import com.standby.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministradorBuilder {

    @Autowired private AdministradorRepository repository;

    public Administrador build(Administrador administrador, AdministradorDTO dto) {

        administrador.setEmail(dto.getEmail());
        administrador.setSenha(dto.getSenha());

        repository.save(administrador);

        return administrador;
    }
}
