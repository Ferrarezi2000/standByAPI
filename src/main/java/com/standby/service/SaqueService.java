package com.standby.service;

import com.standby.model.Saque;
import com.standby.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SaqueService {

    @Autowired private SaqueRepository repository;

    public void sacar(Saque saque, BigDecimal valor) {
        saque.setData(new Date());
        saque.setDescricao("SAQUE");
        saque.setValor(valor);

        repository.save(saque);
    }

}
