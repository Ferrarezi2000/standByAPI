package com.standby.controller;

import com.standby.controller.abstrato.AbstractRestController;
import com.standby.model.Servico;
import com.standby.model.abstrato.ResponseRest;
import com.standby.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController extends AbstractRestController {

    @Autowired private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<List<Servico>> dashboard() {
        return ResponseRest.object(dashboardService.servicos());
    }

}
