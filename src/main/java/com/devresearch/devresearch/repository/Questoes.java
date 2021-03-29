package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Questoes extends JpaRepository<Questao,Integer> {
    List<Questao> findByCategoriaId(Integer id);
}
