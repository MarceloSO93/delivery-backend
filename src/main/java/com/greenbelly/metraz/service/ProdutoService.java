package com.greenbelly.metraz.service;

import com.greenbelly.metraz.dto.ProdutoDTO;
import com.greenbelly.metraz.model.Produto;
import com.greenbelly.metraz.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    public List<ProdutoDTO> findAll() {
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        repository.findAll().forEach(p -> {
            produtoDTOS.add(ProdutoDTO.convertOneDTO(p));
        });
        return produtoDTOS;
    }

    public Produto findOne(Long id) {
        return repository.findById(id).get();
    }

    public List<Produto> findByIdLoja(Long id) {
        return repository.findByIdLoja(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
