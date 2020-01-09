package com.greenbelly.metraz.service;

import com.greenbelly.metraz.dto.LojaProdutosDTO;
import com.greenbelly.metraz.model.Loja;
import com.greenbelly.metraz.model.Usuario;
import com.greenbelly.metraz.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public Loja insert(Loja loja) {
        loja.getResponsavel().setLoja(loja);
        return repository.save(loja);
    }

    public Loja update(Loja loja) {
        return repository.save(loja);
    }

    public List<LojaProdutosDTO> findAll() {

        List<Loja> lojaProdutos = repository.findAll();

        List<LojaProdutosDTO> lojaProdutosDTOList = new ArrayList<>();

        lojaProdutos.forEach(lojaProdutos1 -> {
            lojaProdutosDTOList.add(LojaProdutosDTO.convertOneDTO(lojaProdutos1));
        });

        return lojaProdutosDTOList;
    }

    public LojaProdutosDTO findOne(Long id) {
        return LojaProdutosDTO.convertOneDTO(repository.findById(id).get());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
