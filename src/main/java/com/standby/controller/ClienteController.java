package com.standby.controller;

import com.standby.builder.CadastroClienteBuilder;
import com.standby.builder.ClienteBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.ClienteDTO;
import com.standby.dto.ObjetoDTO;
import com.standby.model.Cliente;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.ClienteRepository;
import com.standby.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController extends AbstractRestController {

    @Autowired private ClienteRepository repository;
    @Autowired private ClienteBuilder builder;
    @Autowired private CadastroClienteBuilder cadastroClienteBuilder;
    @Autowired private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @GetMapping("/completo")
    public ResponseEntity<?> clienteCompleto() {
        return ResponseRest.list(clienteService.completo());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody ObjetoDTO objetoDTO) {
        return ResponseRest.object(cadastroClienteBuilder.build(objetoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Cliente cliente) {
        Assert.notNull(cliente, "Cliente não encontrado.");
        return ResponseRest.object(clienteService.busca(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Cliente cliente, @RequestBody ClienteDTO dto) {
        Assert.notNull(cliente, "Cliente não encontrado.");
        builder.build(cliente, dto);
        return ResponseRest.ok("Cliente alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Cliente cliente) {
        Assert.notNull(cliente, "Cliente não encontrado.");
        repository.delete(cliente);
        return ResponseRest.ok("Cliente excluído com suecesso.");
    }
}
