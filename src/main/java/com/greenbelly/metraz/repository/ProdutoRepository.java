package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select l from Produto l where l.loja.id = ?1")
    List<Produto> findByIdLoja(Long id);

}
