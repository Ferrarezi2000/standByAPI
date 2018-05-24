package com.standby.repository;

import com.standby.model.Cliente;
import com.standby.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

    List<Contato> findAllByCliente(Cliente cliente);
    Contato findTopByCliente(Cliente cliente);
}
