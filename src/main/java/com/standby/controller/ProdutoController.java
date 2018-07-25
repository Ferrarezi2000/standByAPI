package com.standby.controller;

import com.standby.builder.ProdutoBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.ProdutoDTO;
import com.standby.model.Produto;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.ProdutoRepository;
import com.standby.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/produto")
public class ProdutoController extends AbstractRestController {

    @Autowired private ProdutoRepository repository;
    @Autowired private ProdutoBuilder builder;
    @Autowired private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseRest.list(service.lista());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody ProdutoDTO dto) {
        return ResponseRest.object(builder.build(new Produto(), dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Produto produto) {
        Assert.notNull(produto, "Produto não encontrado.");
        return ResponseRest.object(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Produto produto, @RequestBody ProdutoDTO dto) {
        Assert.notNull(produto, "Produto não encontrado.");
        builder.build(produto, dto);
        return ResponseRest.ok("Produto alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Produto produto) {
        Assert.notNull(produto, "Produto não encontrado.");
        repository.delete(produto);
        return ResponseRest.ok("Produto excluído com suecesso.");
    }

}
