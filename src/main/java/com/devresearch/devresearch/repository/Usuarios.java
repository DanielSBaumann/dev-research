package com.devresearch.devresearch.repository;

import com.devresearch.devresearch.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
}
