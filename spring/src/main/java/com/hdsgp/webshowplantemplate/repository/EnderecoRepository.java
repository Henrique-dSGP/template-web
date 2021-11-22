package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
