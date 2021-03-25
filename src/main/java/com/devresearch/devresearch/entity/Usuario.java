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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "email", nullable = false, length = 200, unique = true)
    private String email;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_categoria", nullable = true, foreignKey = @ForeignKey(name = "fk_id_categoria"))
    private Categoria categoria;
}
