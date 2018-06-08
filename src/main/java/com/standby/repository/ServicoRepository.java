package com.standby.repository;

import com.standby.model.Cliente;
import com.standby.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    List<Servico> findByCliente (Cliente cliente);
}
