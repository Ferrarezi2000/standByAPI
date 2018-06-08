package com.standby.controller;

import com.standby.builder.DespesaBuilder;
import com.standby.builder.ServicoBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.DespesaDTO;
import com.standby.dto.ServicoDTO;
import com.standby.model.Cliente;
import com.standby.model.Despesa;
import com.standby.model.Servico;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.DespesaRepository;
import com.standby.repository.ServicoRepository;
import com.standby.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/despesa")
public class DespesaController extends AbstractRestController {

    @Autowired private DespesaRepository repository;
    @Autowired private DespesaBuilder builder;

    @GetMapping
    public ResponseEntity<List<Despesa>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody DespesaDTO dto) {
        return ResponseRest.object(builder.build(new Despesa(), dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Despesa despesa) {
        Assert.notNull(despesa, "Despesa não encontrada.");
        return ResponseRest.object(despesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Despesa despesa, @RequestBody DespesaDTO dto) {
        Assert.notNull(despesa, "Despesa não encontrada.");
        builder.build(despesa, dto);
        return ResponseRest.ok("Despesa alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Despesa despesa) {
        Assert.notNull(despesa, "Despesa não encontrada.");
        repository.delete(despesa);
        return ResponseRest.ok("Despesa excluída com suecesso.");
    }
}
