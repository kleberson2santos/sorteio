package com.loteia.sorteio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loteia.sorteio.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

    Optional<Usuario> findByEmail(String email);
}
