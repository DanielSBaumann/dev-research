package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Pesquisas extends JpaRepository<Pesquisa, Integer> {
    Optional<Pesquisa> findByUsuarioId(Integer id);
}
