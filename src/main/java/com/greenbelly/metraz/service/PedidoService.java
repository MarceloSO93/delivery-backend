package com.greenbelly.metraz.service;

import com.greenbelly.metraz.model.Pedido;
import com.greenbelly.metraz.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido insert(Pedido pedidoProdutos){
        return repository.save(pedidoProdutos);
    }

    public Pedido update(Pedido pedidoProdutos){
        return repository.save(pedidoProdutos);
    }

    public List<Pedido> findAll(){
        return repository.findAll();
    }

    public Pedido findOne(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
