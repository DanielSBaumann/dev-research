package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.entity.RespostasPorQuestaoCategoria;
import com.devresearch.devresearch.entity.Usuario;
import com.devresearch.devresearch.repository.Usuarios;
import com.devresearch.devresearch.service.RespostasPorQuestaoCategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/respostasporquestao")
public class RespostasPorQuestaoCategoriaController {

    @Autowired
    private Usuarios usuarioRepository;

    private RespostasPorQuestaoCategoriaService service;

    public RespostasPorQuestaoCategoriaController(RespostasPorQuestaoCategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> questoesRespostas(@RequestBody String id) {
        try {
            Usuario usuario = usuarioRepository
                    .findById(new Integer(id.replace("=", "")))
                    .get();
            RespostasPorQuestaoCategoria respostas = service
                    .questoesERespostasPorCategoria(usuario
                            .getCategoria()
                            .getId());
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(respostas);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Não deu certo");
        }
    }
}
