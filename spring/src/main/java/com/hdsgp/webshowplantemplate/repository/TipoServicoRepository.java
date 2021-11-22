package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}
