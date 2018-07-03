package com.standby.service;

import com.standby.model.Despesa;
import com.standby.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    @Autowired private DespesaRepository repository;

    public void pagar(Despesa despesa) {
        despesa.setPago(true);

        repository.save(despesa);
    }

    public List<Despesa> faltaPagar(){
        List<Despesa> despesas = repository.findAllByPago(false);

        return despesas;
    }

}
