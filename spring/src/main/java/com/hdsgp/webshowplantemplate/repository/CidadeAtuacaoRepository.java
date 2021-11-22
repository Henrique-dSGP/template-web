package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.Cidade;
import com.hdsgp.webshowplantemplate.model.CidadeAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeAtuacaoRepository extends JpaRepository<CidadeAtuacao, Long> {
}
