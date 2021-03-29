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
@Table(name = "pesquisas")
public class Pesquisa {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "resposta1", nullable = false, length = 200)
    private String resposta1;

    @Column(name = "resposta2", nullable = false, length = 200)
    private String resposta2;

    @Column(name = "resposta3", nullable = false, length = 200)
    private String resposta3;

    @Column(name = "resposta4", nullable = false, length = 200)
    private String resposta4;

    @Column(name = "resposta5", nullable = false, length = 200)
    private String resposta5;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_usuario", nullable = true, foreignKey = @ForeignKey(name = "fk_id_usuario"))
    private Usuario usuario;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_categoria", nullable = true, foreignKey = @ForeignKey(name = "fk_id_categoria"))
    private Categoria categoria;
}
