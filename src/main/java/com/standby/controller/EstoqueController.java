package com.standby.controller;

import com.standby.builder.EstoqueBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.EstoqueDTO;
import com.standby.model.Estoque;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.EstoqueRepository;
import com.standby.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/estoque")
public class EstoqueController extends AbstractRestController {

    @Autowired private EstoqueRepository repository;
    @Autowired private EstoqueBuilder builder;

    @GetMapping
    public ResponseEntity<List<Estoque>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody EstoqueDTO dto) {
        return ResponseRest.object(builder.build(new Estoque(), dto));
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> buscar(@PathVariable("id") Produto produto) {
//        Assert.notNull(produto, "Produto não encontrado.");
//        return ResponseRest.object(produto);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> alterar(@PathVariable("id") Produto produto, @RequestBody ProdutoDTO dto) {
//        Assert.notNull(produto, "Produto não encontrado.");
//        builder.build(produto, dto);
//        return ResponseRest.ok("Produto alterado com sucesso!");
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletar(@PathVariable("id") Produto produto) {
//        Assert.notNull(produto, "Produto não encontrado.");
//        repository.delete(produto);
//        return ResponseRest.ok("Produto excluído com suecesso.");
//    }

}
