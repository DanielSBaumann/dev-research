package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Respostas extends JpaRepository<Resposta,Integer> {
    List<Resposta>findByQuestaoId(Integer id);
}
