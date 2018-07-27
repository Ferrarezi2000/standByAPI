package com.standby.controller;

import com.standby.controller.abstrato.AbstractRestController;
import com.standby.model.Saque;
import com.standby.model.abstrato.ResponseRest;
import com.standby.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/saque")
public class SaqueController extends AbstractRestController {

    @Autowired private SaqueRepository repository;

    @GetMapping
    public ResponseEntity<List<Saque>> listar() {
        return ResponseRest.list(repository.findAll());
    }
}
