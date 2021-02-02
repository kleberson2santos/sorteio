package com.loteia.sorteio.repository;

import com.loteia.sorteio.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {
}
