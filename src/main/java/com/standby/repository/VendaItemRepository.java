package com.standby.repository;

import com.standby.model.Venda;
import com.standby.model.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaItemRepository extends JpaRepository<VendaItem, Long>{
    List<VendaItem> findAllByVenda(Venda venda);

}
