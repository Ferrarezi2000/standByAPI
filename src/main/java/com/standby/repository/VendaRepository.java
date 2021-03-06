package com.standby.repository;

import com.standby.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long>{

    List<Venda> findAllBySacado(Boolean valor);

}
