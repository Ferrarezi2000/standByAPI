package com.standby.repository;

import com.standby.model.Cliente;
import com.standby.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    Endereco findTopByCliente(Cliente cliente);
}
