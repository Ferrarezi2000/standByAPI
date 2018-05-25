package com.standby.controller;

import com.standby.builder.AdministradorBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.AdministradorDTO;
import com.standby.model.Administrador;
import com.standby.model.Cliente;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.AdministradorRepository;
import com.standby.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/adm")
public class AdministradorController extends AbstractRestController {

    @Autowired private AdministradorRepository repository;
    @Autowired private AdministradorBuilder builder;
    @Autowired private AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody AdministradorDTO administradorDTO) {
        return ResponseRest.object(builder.build(new Administrador(), administradorDTO));
    }

    @PostMapping("/logar")
    public ResponseEntity<?> logar(@RequestBody AdministradorDTO administradorDTO) {
        Administrador administrador = administradorService.logar(administradorDTO);
        Assert.notNull(administrador, "Administrador não encontrado.");
        return ResponseRest.object(administrador);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Administrador administrador) {
        Assert.notNull(administrador, "Administrador não encontrado.");
        return ResponseRest.object(administrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable("id") Administrador administrador, @RequestBody AdministradorDTO dto) {
        Assert.notNull(administrador, "Administrador não encontrado.");
        builder.build(administrador, dto);
        return ResponseRest.ok("Administrador alterado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Administrador administrador) {
        Assert.notNull(administrador, "Administrador não encontrado.");
        repository.delete(administrador);
        return ResponseRest.ok("Administrador excluído com suecesso.");
    }
}
