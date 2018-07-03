package com.standby.repository;

import com.standby.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
    List<Despesa> findAllByPago(Boolean falso);

}
