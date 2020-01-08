package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.CategoriaLoja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaLojasRepository extends JpaRepository<CategoriaLoja, Long> {
}
