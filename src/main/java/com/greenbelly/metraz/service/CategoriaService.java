package com.greenbelly.metraz.service;


import com.greenbelly.metraz.model.CategoriaLoja;
import com.greenbelly.metraz.model.ModalidadeTrabalho;
import com.greenbelly.metraz.repository.CategoriaLojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

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

    public List<CategoriaLoja> findByModalidadeTrabalho(ModalidadeTrabalho modalidadeTrabalho){
        return repository.findByModalidadeTrabalho(modalidadeTrabalho);
    }

    public CategoriaLoja findOne(Long id){
        return repository.findById(id).get();
    }

    public String saveImage(Long id, byte[] foto) {
        CategoriaLoja categoria = repository.findById(id).get();
        categoria.setImage(foto);
        repository.save(categoria);
        return Base64Utils.encodeToString(foto);
    }

    public String getFoto(Long id) {
        byte[] foto = repository.findById(id).get().getImage();
        return foto != null ? Base64Utils.encodeToString(
                foto
        ) : null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
