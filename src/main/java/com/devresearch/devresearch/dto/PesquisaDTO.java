package com.devresearch.devresearch.dto;

import com.devresearch.devresearch.enums.RespostaPesquisa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesquisaDTO {

    private RespostaPesquisa resposta1;
    private RespostaPesquisa resposta2;
    private RespostaPesquisa resposta3;
    private RespostaPesquisa resposta4;
    private RespostaPesquisa resposta5;

}
