package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UF, Long> {
}
