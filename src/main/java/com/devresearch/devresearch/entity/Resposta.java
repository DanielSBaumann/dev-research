package com.devresearch.devresearch.entity;

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
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "resposta", nullable = false, length = 200)
    private String resposta;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_questao", nullable = true, foreignKey = @ForeignKey(name = "fk_id_questao"))
    private Questao questao;
}
