package com.devresearch.devresearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RespostasPorQuestaoCategoria {
    private List<Questao>questoes;
    private List<Resposta>respostasQuestao1;
    private List<Resposta>respostasQuestao2;
    private List<Resposta>respostasQuestao3;
    private List<Resposta>respostasQuestao4;
    private List<Resposta>respostasQuestao5;
}
