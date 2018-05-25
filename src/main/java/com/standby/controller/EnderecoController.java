package com.standby.controller;

import com.standby.builder.EnderecoBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.EnderecoDTO;
import com.standby.model.Endereco;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/endereco")
public class EnderecoController extends AbstractRestController {

    @Autowired private EnderecoRepository repository;
    @Autowired private EnderecoBuilder builder;

    @GetMapping
    public ResponseEntity<List<Endereco>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscar(@PathVariable("id") Endereco endereco) {
        Assert.notNull(endereco, "Endereço não encontrado.");
        return ResponseRest.object(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Endereco endereco, @RequestBody EnderecoDTO dto) {
        Assert.notNull(endereco, "Endereço não encontrado.");
        builder.build(endereco, dto);
        return ResponseRest.ok("Endereço alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Endereco endereco) {
        Assert.notNull(endereco, "Endereço não encontrado.");
        repository.delete(endereco);
        return ResponseRest.ok("Endereço excluído com suecesso.");
    }
}
