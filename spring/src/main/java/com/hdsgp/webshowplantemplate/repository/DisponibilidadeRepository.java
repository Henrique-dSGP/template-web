package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {
}
