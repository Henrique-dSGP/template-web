package com.hdsgp.webshowplantemplate.repository;

import com.hdsgp.webshowplantemplate.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
