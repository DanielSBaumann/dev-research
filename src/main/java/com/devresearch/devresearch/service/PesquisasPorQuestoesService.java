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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PesquisasPorQuestoesService {

    @Autowired
    private Questoes questoesRepository;

    @Autowired
    private Pesquisas pesquisasRepository;

    @Transactional
    public List<CategoriaChart> chart() {
        List<CategoriaChart> chart = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            chart.add(categoriaChart(i));
        }
        return chart;
    }

    @Transactional
    public CategoriaChart categoriaChart(Integer idCategoria) {
        switch (idCategoria) {
            case 1: {
                return categoriaChartJR();
            }
            case 2: {
                return categoriaChartSR();
            }
            case 3: {
                return categoriaChartRH();
            }
            default: {
                return null;
            }
        }
    }

    public CategoriaChart categoriaChartJR() {
        List<QuestoesChart> questoes = questoesERespostasPorCategoria(1);
        CategoriaChart chart = CategoriaChart
                .builder()
                .categoria("JR")
                .questoes(questoes)
                .build();
        return chart;
    }

    public CategoriaChart categoriaChartSR() {
        List<QuestoesChart> questoes = questoesERespostasPorCategoria(2);
        CategoriaChart chart = CategoriaChart
                .builder()
                .categoria("SR")
                .questoes(questoes)
                .build();
        return chart;
    }

    public CategoriaChart categoriaChartRH() {
        List<QuestoesChart> questoes = questoesERespostasPorCategoria(3);
        CategoriaChart chart = CategoriaChart
                .builder()
                .categoria("RH")
                .questoes(questoes)
                .build();
        return chart;
    }

    @Transactional
    public List<QuestoesChart> questoesERespostasPorCategoria(Integer idCategoria) {
        List<Questao> questoes = questoesRepository
                .findByCategoriaId(idCategoria);
        List<QuestoesChart> qc = new ArrayList<>();
        for (int i = 0; i < questoes.size(); i++) {
            List<RespostasChart> respostasChart = respostaPorNumeroQuestao(i + 1, idCategoria);
            QuestoesChart questao = QuestoesChart
                    .builder()
                    .id(questoes.get(i).getId())
                    .enunciado(questoes.get(i).getEnunciado())
                    .respostas(respostasChart)
                    .build();
            qc.add(questao);
        }
        return qc;
    }


    @Transactional
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
            default: {
                return null;
            }
        }
    }


    @Transactional
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

    @Transactional
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

    @Transactional
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

    @Transactional
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

    @Transactional
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




























