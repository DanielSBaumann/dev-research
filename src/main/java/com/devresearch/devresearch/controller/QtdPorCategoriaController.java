package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.dto.QtdPorCategoriaChart;
import com.devresearch.devresearch.repository.Categorias;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/qtdporcategoria")
public class QtdPorCategoriaController {

    @Autowired
    Categorias categoriaRepository;

    @PostMapping
    public ResponseEntity<?> contador() {
        try {
            List<Object[]> list = categoriaRepository.qtdPorCategoria();
            List<QtdPorCategoriaChart> qtdPorCategorias = new ArrayList<>();
            for (Object[] obj : list) {
                QtdPorCategoriaChart cat = QtdPorCategoriaChart
                        .builder()
                        .categoria((String) obj[0])
                        .qtd(new Integer(obj[1].toString()))
                        .build();
                qtdPorCategorias.add(cat);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(qtdPorCategorias);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("");
        }

    }
}

















