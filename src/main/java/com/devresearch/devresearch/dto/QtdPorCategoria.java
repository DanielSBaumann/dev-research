package com.devresearch.devresearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QtdPorCategoria {
    private String categoria;
    private Integer qtd;
}
