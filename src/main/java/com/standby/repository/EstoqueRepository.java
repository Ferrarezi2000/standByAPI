package com.standby.repository;

import com.standby.model.Estoque;
import com.standby.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
    Estoque findByProduto (Produto produto);

}
