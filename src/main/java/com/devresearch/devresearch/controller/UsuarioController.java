package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.dto.UsuarioDTO;
import com.devresearch.devresearch.entity.Categoria;
import com.devresearch.devresearch.entity.Usuario;
import com.devresearch.devresearch.repository.Categorias;
import com.devresearch.devresearch.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private Usuarios repository;

    @Autowired
    private Categorias categoriaRepository;

    @GetMapping("/new")
    public ModelAndView user(UsuarioDTO usuarioDTO) {
        return new ModelAndView("usuario");
    }

    @GetMapping("/**")
    public ModelAndView redirect(UsuarioDTO usuarioDTO) {
        return new ModelAndView("redirect:/usuario/new");
    }

    @PostMapping
    public ModelAndView create(@Valid UsuarioDTO usuarioDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || repository.existsByEmail(usuarioDTO.getEmail())) {
            System.out.println("COM ERRO\n" + usuarioDTO.toString());
            return new ModelAndView("usuario");
        }
        /*else if (repository.existsByEmail(usuarioDTO.getEmail())) {
            return new ModelAndView("usuario");
        }*/
        System.out.println("SEM ERRO\n" + usuarioDTO.toString());

        Categoria categoria = categoriaRepository
                .findByCategoria(usuarioDTO
                        .getCategoria()).get();

        Usuario usuario = Usuario
                .builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .categoria(categoria)
                .build();

        Usuario newUser = repository.save(usuario);

        return new ModelAndView("redirect:/questionario/" + newUser.getId());
    }
}
