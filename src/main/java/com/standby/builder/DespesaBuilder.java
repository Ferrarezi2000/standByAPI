package com.standby.builder;

import com.standby.dto.DespesaDTO;
import com.standby.model.Despesa;
import com.standby.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DespesaBuilder {

    @Autowired private DespesaRepository repository;

    public Despesa build(Despesa despesa, DespesaDTO dto) {

        despesa.setDataVencimento(dto.getDataVencimento());
        despesa.setDescricao(dto.getDescricao());
        despesa.setValor(dto.getValor());

        if (dto.getPago() == null || !dto.getPago()) {
            despesa.setPago(false);
        } else {
            despesa.setPago(dto.getPago());
        }

        repository.save(despesa);

        return despesa;
    }
}
