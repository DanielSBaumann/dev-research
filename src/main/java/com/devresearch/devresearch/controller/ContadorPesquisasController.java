package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.repository.Pesquisas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contador")
public class ContadorPesquisasController {

    @Autowired
    private Pesquisas pesquisaRepository;

    @PostMapping
    public ResponseEntity<?> contador() {
        Long contador = pesquisaRepository.countAll();
        return ResponseEntity.ok(contador);
    }
}
