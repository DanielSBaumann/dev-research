package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Categoria;
import com.devresearch.devresearch.enums.CategoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * SELECT categorias.categoria,COUNT(*)
 * FROM categorias
 * INNER JOIN usuarios
 * ON categorias.id = usuarios.id_categoria
 * GROUP BY categorias.categoria;
 */

public interface Categorias extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByCategoria(CategoriaUsuario categoria);

    @Query(value = "SELECT " +
            "categorias.categoria,COUNT(*) AS qtd " +
            "FROM categorias " +
            "INNER JOIN usuarios " +
            "ON categorias.id = usuarios.id_categoria " +
            "GROUP BY categorias.categoria;"
            , nativeQuery = true)
    List<Object[]> qtdPorCategoria();
}
