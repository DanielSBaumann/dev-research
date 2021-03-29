package com.devresearch.devresearch.service;

import com.devresearch.devresearch.entity.Questao;
import com.devresearch.devresearch.entity.Resposta;
import com.devresearch.devresearch.entity.RespostasPorQuestaoCategoria;
import com.devresearch.devresearch.repository.Questoes;
import com.devresearch.devresearch.repository.Respostas;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RespostasPorQuestaoCategoriaService {

    @Autowired
    private Questoes questoesRepository;
    @Autowired
    private Respostas respostasRepository;

    @Transactional
    public RespostasPorQuestaoCategoria questoesERespostasPorCategoria(Integer idCategoria) {

        List<Questao> questoes = questoesRepository
                .findByCategoriaId(idCategoria);

        List<Resposta> resposta1 = respostasRepository
                .findByQuestaoId(questoes.get(0).getId());

        List<Resposta> resposta2 = respostasRepository
                .findByQuestaoId(questoes.get(1).getId());

        List<Resposta> resposta3 = respostasRepository
                .findByQuestaoId(questoes.get(2).getId());

        List<Resposta> resposta4 = respostasRepository
                .findByQuestaoId(questoes.get(3).getId());

        List<Resposta> resposta5 = respostasRepository
                .findByQuestaoId(questoes.get(4).getId());

        RespostasPorQuestaoCategoria respostasPorQuestaoCategoria = RespostasPorQuestaoCategoria
                .builder()
                .questoes(questoes)
                .respostasQuestao1(resposta1)
                .respostasQuestao2(resposta2)
                .respostasQuestao3(resposta3)
                .respostasQuestao4(resposta4)
                .respostasQuestao5(resposta5)
                .build();

        return respostasPorQuestaoCategoria;
    }
}
