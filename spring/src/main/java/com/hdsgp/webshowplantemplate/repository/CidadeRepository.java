package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
