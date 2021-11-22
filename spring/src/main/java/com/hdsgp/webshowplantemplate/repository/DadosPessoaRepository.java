package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.DadosPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosPessoaRepository extends JpaRepository<DadosPessoa, Long> {
}
