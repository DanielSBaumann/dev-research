package com.devresearch.devresearch.entity;

import com.devresearch.devresearch.enums.RespostaPesquisa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "pesquisas")
public class Pesquisa {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RespostaPesquisa resposta1;

    @Enumerated(EnumType.STRING)
    private RespostaPesquisa resposta2;

    @Enumerated(EnumType.STRING)
    private RespostaPesquisa resposta3;

    @Enumerated(EnumType.STRING)
    private RespostaPesquisa resposta4;

    @Enumerated(EnumType.STRING)
    private RespostaPesquisa resposta5;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_usuario", nullable = true, foreignKey = @ForeignKey(name = "fk_id_usuario"))
    private Usuario usuario;
}
