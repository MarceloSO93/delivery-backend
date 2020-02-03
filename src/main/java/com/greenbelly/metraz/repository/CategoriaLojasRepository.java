package com.greenbelly.metraz.repository;

import com.greenbelly.metraz.model.CategoriaLoja;
import com.greenbelly.metraz.model.ModalidadeTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaLojasRepository extends JpaRepository<CategoriaLoja, Long> {

    @Query("select c from CategoriaLoja c where c.modalidadeTrabalho = ?1")
    List<CategoriaLoja> findByModalidadeTrabalho(ModalidadeTrabalho modalidadeTrabalho);

}
