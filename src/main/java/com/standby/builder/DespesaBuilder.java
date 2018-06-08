package com.standby.builder;

import com.standby.dto.DespesaDTO;
import com.standby.model.Despesa;
import com.standby.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DespesaBuilder {

    @Autowired private DespesaRepository repository;

    public Despesa build(Despesa despesa, DespesaDTO dto) {

        despesa.setData(new Date());
        despesa.setDescricao(dto.getDescricao());
        despesa.setValor(dto.getValor());

        repository.save(despesa);

        return despesa;
    }
}
