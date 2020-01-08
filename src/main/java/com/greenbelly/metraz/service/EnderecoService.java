package com.greenbelly.metraz.service;

import com.greenbelly.metraz.model.Endereco;
import com.greenbelly.metraz.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco insert(Endereco endereco){
        return repository.save(endereco);
    }

    public Endereco update(Endereco endereco){
        return repository.save(endereco);
    }

    public List<Endereco> findAll(){
        return repository.findAll();
    }

    public Endereco findOne(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
