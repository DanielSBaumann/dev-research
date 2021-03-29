package com.devresearch.devresearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespostasChart {
    private String resposta;
    private Integer qtdVezesRespondido;
}
