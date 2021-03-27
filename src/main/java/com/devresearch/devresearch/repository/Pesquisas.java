package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Pesquisas extends JpaRepository<Pesquisa, Integer> {
    Optional<Pesquisa> findByUsuarioId(Integer id);

    @Query("SELECT COUNT(*) FROM Pesquisa s")
    long countAll();
}
