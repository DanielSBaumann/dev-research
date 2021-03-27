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
    private RespostaPesquisa resposta1;
    @NotNull
    private RespostaPesquisa resposta2;
    @NotNull
    private RespostaPesquisa resposta3;
    @NotNull
    private RespostaPesquisa resposta4;
    @NotNull
    private RespostaPesquisa resposta5;
    @Min(1)
    private Integer idUsuario;
}
