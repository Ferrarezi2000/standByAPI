package com.standby.repository;

import com.standby.model.Cliente;
import com.standby.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    List<Servico> findByCliente (Cliente cliente);
    List<Servico> findAllByPagoAndStatus (Boolean condicao, String status);
    List<Servico> findAllByPago (Boolean condicao);
    List<Servico> findAllByStatus (String status);
}
