package com.devresearch.devresearch.dto;

import com.devresearch.devresearch.enums.RespostaPesquisa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesquisaDTO {

    @NotNull
    private String resposta1;
    @NotNull
    private String resposta2;
    @NotNull
    private String resposta3;
    @NotNull
    private String resposta4;
    @NotNull
    private String resposta5;
    @Min(1)
    private Integer idUsuario;
}
