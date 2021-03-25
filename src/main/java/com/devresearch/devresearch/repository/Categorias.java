package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Categoria;
import com.devresearch.devresearch.enums.CategoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Categorias extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByCategoria(CategoriaUsuario categoria);
}
