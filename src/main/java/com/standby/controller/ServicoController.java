package com.standby.controller;

import com.standby.builder.ServicoBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.ServicoDTO;
import com.standby.model.Cliente;
import com.standby.model.Servico;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.ServicoRepository;
import com.standby.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/servico")
public class ServicoController extends AbstractRestController {

    @Autowired private ServicoRepository repository;
    @Autowired private ServicoBuilder builder;
    @Autowired private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @GetMapping("/completa")
    public ResponseEntity<List<Servico>> listaCompleta() {
        return ResponseRest.list(service.listaCompleta());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody ServicoDTO dto) {
        return ResponseRest.object(builder.build(new Servico(), dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Servico servico) {
        Assert.notNull(servico, "Serviço não encontrado.");
        return ResponseRest.object(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Servico servico, @RequestBody ServicoDTO dto) {
        Assert.notNull(servico, "Serviço não encontrado.");
        builder.build(servico, dto);
        return ResponseRest.ok("Serviço alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Servico servico) {
        Assert.notNull(servico, "Serviço não encontrado.");
        repository.delete(servico);
        return ResponseRest.ok("Serviço excluído com suecesso.");
    }
}
