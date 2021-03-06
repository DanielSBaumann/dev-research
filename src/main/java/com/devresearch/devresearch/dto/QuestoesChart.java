package com.devresearch.devresearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestoesChart {
    private Integer id;
    private String enunciado;
    private List<RespostasChart> respostas;
}
