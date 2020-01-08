package com.greenbelly.metraz.service;


import com.greenbelly.metraz.model.CategoriaLoja;
import com.greenbelly.metraz.repository.CategoriaLojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaLojasRepository repository;

    public CategoriaLoja insert(CategoriaLoja categoriaLoja){
        return repository.save(categoriaLoja);
    }

    public CategoriaLoja update(CategoriaLoja categoriaLoja){
        return repository.save(categoriaLoja);
    }

    public List<CategoriaLoja> findAll(){
        return repository.findAll();
    }

    public CategoriaLoja findOne(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
