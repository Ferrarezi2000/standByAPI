package com.standby.controller;

import com.standby.controller.abstrato.AbstractRestController;
import com.standby.model.Venda;
import com.standby.model.VendaItem;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.VendaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vendaItem")
public class VendaItemController extends AbstractRestController {

    @Autowired private VendaItemRepository repository;

    @GetMapping
    public ResponseEntity<List<VendaItem>> listar() {
        return ResponseRest.list(repository.findAll());
    }

    @GetMapping("/venda/{id}")
    public ResponseEntity<List<VendaItem>> listar(@PathVariable("id") Venda venda) {
        return ResponseRest.list(repository.findAllByVenda(venda));
    }

}
