package com.greenbelly.metraz.service;

import com.greenbelly.metraz.dto.LojaProdutosDTO;
import com.greenbelly.metraz.model.Loja;
import com.greenbelly.metraz.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

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

    public List<LojaProdutosDTO> findByIdCAtegoria(Long id) {

        List<Loja> lojaProdutos = repository.findByIdCategoria(id);

        List<LojaProdutosDTO> lojaProdutosDTOList = new ArrayList<>();

        lojaProdutos.forEach(lojaProdutos1 -> {
            lojaProdutosDTOList.add(LojaProdutosDTO.convertOneDTO(lojaProdutos1));
        });

        return lojaProdutosDTOList;
    }

    public String saveImage(Long id, byte[] foto) {
        Loja loja = repository.findById(id).get();
        loja.setLogo(foto);
        repository.save(loja);
        return Base64Utils.encodeToString(foto);
    }

    public String getFoto(Long id) {
        byte[] foto = repository.findById(id).get().getLogo();
        return foto != null ? Base64Utils.encodeToString(
                foto
        ) : null;
    }

    public LojaProdutosDTO findOne(Long id) {
        return LojaProdutosDTO.convertOneDTO(repository.findById(id).get());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
