package com.devresearch.devresearch.service;

import com.devresearch.devresearch.dto.CategoriaChart;
import com.devresearch.devresearch.dto.QuestoesChart;
import com.devresearch.devresearch.dto.RespostasChart;
import com.devresearch.devresearch.entity.Questao;
import com.devresearch.devresearch.repository.Pesquisas;
import com.devresearch.devresearch.repository.Questoes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PesquisasPorQuestoesService {

    /**
     * Objetivo é retornar aqui no fim
     * uma lista do seguinte tipo :
     * List<CategoriaChart>
     * fazer passo a passo...
     */

    @Autowired
    private Questoes questoesRepository;

    @Autowired
    private Pesquisas pesquisasRepository;

    public List<CategoriaChart> chart() {

        List<Questao> questoesJR = questoesRepository
                .findByCategoriaId(1);


        return null;
    }

    /**
     *
     * Continuar daqui
     * verificar retorno antes de utilizar
     */
    public List<Questao> questoesJR() {

        List<Questao> questoesJR = questoesRepository
                .findByCategoriaId(1);

        List<QuestoesChart> qc = new ArrayList<>();

        questoesJR.forEach(item -> {

            QuestoesChart questao = QuestoesChart
                    .builder()
                    .id(item.getId())
                    .enunciado(item.getEnunciado())
                    .respostas(null)
                    .build();

        });


        return null;
    }

    public List<RespostasChart> respostaPorNumeroQuestao(Integer questao, Integer idCategoria) {
        switch (questao) {
            case 1: {
                return respostasQuestao1(idCategoria);
            }
            case 2: {
                return respostasQuestao2(idCategoria);
            }
            case 3: {
                return respostasQuestao3(idCategoria);
            }
            case 4: {
                return respostasQuestao4(idCategoria);
            }
            case 5: {
                return respostasQuestao5(idCategoria);
            }
            default:{
                return  null;
            }
        }
    }


    public List<RespostasChart> respostasQuestao1(Integer idCategoria) {
        List<Object[]> list = pesquisasRepository
                .qtdRespostas1(idCategoria);
        List<RespostasChart> respostas = new ArrayList<>();
        list.forEach(item -> {
            RespostasChart resp = RespostasChart
                    .builder()
                    .resposta(item[0].toString())
                    .qtdVezesRespondido(new Integer(item[1].toString()))
                    .build();
            respostas.add(resp);
        });
        return respostas;
    }

    public List<RespostasChart> respostasQuestao2(Integer idCategoria) {
        List<Object[]> list = pesquisasRepository
                .qtdRespostas2(idCategoria);
        List<RespostasChart> respostas = new ArrayList<>();
        list.forEach(item -> {
            RespostasChart resp = RespostasChart
                    .builder()
                    .resposta(item[0].toString())
                    .qtdVezesRespondido(new Integer(item[1].toString()))
                    .build();
            respostas.add(resp);
        });
        return respostas;
    }

    public List<RespostasChart> respostasQuestao3(Integer idCategoria) {
        List<Object[]> list = pesquisasRepository
                .qtdRespostas3(idCategoria);
        List<RespostasChart> respostas = new ArrayList<>();
        list.forEach(item -> {
            RespostasChart resp = RespostasChart
                    .builder()
                    .resposta(item[0].toString())
                    .qtdVezesRespondido(new Integer(item[1].toString()))
                    .build();
            respostas.add(resp);
        });
        return respostas;
    }

    public List<RespostasChart> respostasQuestao4(Integer idCategoria) {
        List<Object[]> list = pesquisasRepository
                .qtdRespostas4(idCategoria);
        List<RespostasChart> respostas = new ArrayList<>();
        list.forEach(item -> {
            RespostasChart resp = RespostasChart
                    .builder()
                    .resposta(item[0].toString())
                    .qtdVezesRespondido(new Integer(item[1].toString()))
                    .build();
            respostas.add(resp);
        });
        return respostas;
    }

    public List<RespostasChart> respostasQuestao5(Integer idCategoria) {
        List<Object[]> list = pesquisasRepository
                .qtdRespostas5(idCategoria);
        List<RespostasChart> respostas = new ArrayList<>();
        list.forEach(item -> {
            RespostasChart resp = RespostasChart
                    .builder()
                    .resposta(item[0].toString())
                    .qtdVezesRespondido(new Integer(item[1].toString()))
                    .build();
            respostas.add(resp);
        });
        return respostas;
    }

}




























