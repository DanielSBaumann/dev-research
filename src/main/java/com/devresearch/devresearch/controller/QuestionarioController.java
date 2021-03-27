package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.dto.PesquisaDTO;
import com.devresearch.devresearch.entity.Pesquisa;
import com.devresearch.devresearch.entity.Usuario;
import com.devresearch.devresearch.repository.Pesquisas;
import com.devresearch.devresearch.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/questionario")
public class QuestionarioController {

    @Autowired
    private Usuarios usuarioRepository;

    @Autowired
    private Pesquisas pesquisaRepository;

    @GetMapping
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/{id}")
    public ModelAndView questionario(@PathVariable Integer id) {
        System.out.println("Id usuario que fara a pesquisa -> " + id);

        //verificar se ja existe o usuario
        //verificar se não existe pesquisa do mesmo usuario
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        Optional<Pesquisa> optionalPesquisa = pesquisaRepository.findByUsuarioId(id);

        if (optionalUsuario.isPresent()) {
            System.out.println("usuario no data base");
            if (optionalPesquisa.isPresent()) {
                System.out.println("Pesquisa do usuario no data base");
            } else {
                System.out.println("Usuario ainda não fez pesquisa");
            }
        } else {
            System.out.println("usuario não cadastrado");
        }
        ModelAndView mv = new ModelAndView("questionario");
        mv.addObject("idUsuario", id);
        return mv;
    }

    @PostMapping
    public ModelAndView create(@Valid PesquisaDTO pesquisaDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("COM ERRO\n" + pesquisaDTO.toString());
            return new ModelAndView("redirect:/questionario/" + pesquisaDTO.getIdUsuario());
        } else {
            System.out.println("Testando pesquisa!");
            System.out.println(pesquisaDTO.toString());

            Usuario usuario = usuarioRepository
                    .findById(pesquisaDTO.getIdUsuario())
                    .get();

            Pesquisa pesquisa = Pesquisa
                    .builder()
                    .usuario(usuario)
                    .resposta1(pesquisaDTO.getResposta1())
                    .resposta2(pesquisaDTO.getResposta2())
                    .resposta3(pesquisaDTO.getResposta3())
                    .resposta4(pesquisaDTO.getResposta4())
                    .resposta5(pesquisaDTO.getResposta5())
                    .build();

            Pesquisa newPesquisa = pesquisaRepository.save(pesquisa);

            System.out.println(newPesquisa.toString());

            return new ModelAndView("redirect:/resultado");
        }
    }
}
