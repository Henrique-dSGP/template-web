package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
