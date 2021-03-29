package com.devresearch.devresearch.controller;

import com.devresearch.devresearch.dto.PesquisaDTO;
import com.devresearch.devresearch.entity.Categoria;
import com.devresearch.devresearch.entity.Pesquisa;
import com.devresearch.devresearch.entity.Usuario;
import com.devresearch.devresearch.repository.Categorias;
import com.devresearch.devresearch.repository.Pesquisas;
import com.devresearch.devresearch.repository.Questoes;
import com.devresearch.devresearch.repository.Usuarios;
import com.devresearch.devresearch.service.RespostasPorQuestaoCategoriaService;
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
    private Categorias categoriaRepository;
    @Autowired
    private Pesquisas pesquisaRepository;
    @Autowired
    private Questoes questoesRepository;

    private RespostasPorQuestaoCategoriaService service;

    public QuestionarioController(RespostasPorQuestaoCategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/{id}")
    public ModelAndView questionario(@PathVariable Integer id) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        Optional<Pesquisa> optionalPesquisa = pesquisaRepository.findByUsuarioId(id);

        if (optionalUsuario.isPresent()) {
            if (optionalPesquisa.isPresent()) {
                return new ModelAndView("index");
            } else {

                ModelAndView mv = new ModelAndView("questionario");
                mv.addObject("idUsuario", id);
                return mv;
            }
        } else {
            return new ModelAndView("redirect:/usuario/new");
        }
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


            Categoria categoria = categoriaRepository
                    .findById(usuario
                            .getCategoria()
                            .getId())
                    .get();


            Pesquisa pesquisa = Pesquisa
                    .builder()
                    .usuario(usuario)
                    .categoria(categoria)
                    .resposta1(pesquisaDTO.getResposta1())
                    .resposta2(pesquisaDTO.getResposta2())
                    .resposta3(pesquisaDTO.getResposta3())
                    .resposta4(pesquisaDTO.getResposta4())
                    .resposta5(pesquisaDTO.getResposta5())
                    .build();

            Pesquisa newPesquisa = pesquisaRepository.save(pesquisa);

            return new ModelAndView("redirect:/resultado");
        }
    }
}
