package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.dto.CategoriaChart;
import com.devresearch.devresearch.service.PesquisasPorQuestoesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chart")
public class ChartController {

    public ChartController(PesquisasPorQuestoesService service) {
        this.service = service;
    }

    private PesquisasPorQuestoesService service;

    @PostMapping
    public ResponseEntity<?> chart() {
        try {
            List<CategoriaChart> chart = service
                    .chart();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper
                    .writeValueAsString(chart);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Não deu certo");
        }
    }
}
