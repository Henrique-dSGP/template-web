package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.TipoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Long> {
}
