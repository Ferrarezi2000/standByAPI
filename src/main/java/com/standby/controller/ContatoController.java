package com.standby.controller;

import com.standby.builder.ContatoBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.ContatoDTO;
import com.standby.model.Cliente;
import com.standby.model.Contato;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/contato")
public class ContatoController extends AbstractRestController {

    @Autowired private ContatoRepository repository;
    @Autowired private ContatoBuilder builder;

    @GetMapping
    public ResponseEntity<List<Contato>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody ContatoDTO contatoDTO) {
        return ResponseRest.object(builder.build(new Contato(), contatoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscar(@PathVariable("id") Contato contato) {
        Assert.notNull(contato, "Contato não encontrado.");
        return ResponseRest.object(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Contato contato, @RequestBody ContatoDTO dto) {
        Assert.notNull(contato, "Contato não encontrado.");
        builder.build(contato, dto);
        return ResponseRest.ok("Contato alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Contato contato) {
        Assert.notNull(contato, "Contato não encontrado.");
        repository.delete(contato);
        return ResponseRest.ok("Contato excluído com suecesso.");
    }
}
