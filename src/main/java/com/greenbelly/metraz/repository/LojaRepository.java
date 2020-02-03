package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

    @Query("select l from Loja l where l.categoriaLoja.id = ?1")
    List<Loja> findByIdCategoria(Long id);

}
