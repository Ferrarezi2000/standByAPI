package com.standby.controller;

import com.standby.builder.VendaBuilder;
import com.standby.controller.abstrato.AbstractRestController;
import com.standby.dto.VendaDTO;
import com.standby.model.Venda;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/venda")
public class VendaController extends AbstractRestController {

    @Autowired private VendaRepository repository;
    @Autowired private VendaBuilder builder;

    @GetMapping
    public ResponseEntity<List<Venda>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody VendaDTO dto) {
        return ResponseRest.object(builder.build(new Venda(), dto));
    }

}
