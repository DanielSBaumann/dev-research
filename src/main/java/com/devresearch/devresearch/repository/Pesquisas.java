package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Pesquisas extends JpaRepository<Pesquisa, Integer> {
    Optional<Pesquisa> findByUsuarioId(Integer id);

    @Query("SELECT COUNT(*) FROM Pesquisa s")
    long countAll();

    @Query(value = "SELECT " +
            "resposta1," +
            "COUNT(*) " +
            "FROM pesquisas " +
            "WHERE id_categoria= :id " +
            "GROUP BY resposta1;"
            , nativeQuery = true)
    List<Object[]> qtdRespostas1(Integer id);

    @Query(value = "SELECT " +
            "resposta2," +
            "COUNT(*) " +
            "FROM pesquisas " +
            "WHERE id_categoria= :id " +
            "GROUP BY resposta2;"
            , nativeQuery = true)
    List<Object[]> qtdRespostas2(Integer id);

    @Query(value = "SELECT " +
            "resposta3," +
            "COUNT(*) " +
            "FROM pesquisas " +
            "WHERE id_categoria= :id " +
            "GROUP BY resposta3;"
            , nativeQuery = true)
    List<Object[]> qtdRespostas3(Integer id);

    @Query(value = "SELECT " +
            "resposta4," +
            "COUNT(*) " +
            "FROM pesquisas " +
            "WHERE id_categoria= :id " +
            "GROUP BY resposta4;"
            , nativeQuery = true)
    List<Object[]> qtdRespostas4(Integer id);

    @Query(value = "SELECT " +
            "resposta5," +
            "COUNT(*) " +
            "FROM pesquisas " +
            "WHERE id_categoria= :id " +
            "GROUP BY resposta5;"
            , nativeQuery = true)
    List<Object[]> qtdRespostas5(Integer id);


}
