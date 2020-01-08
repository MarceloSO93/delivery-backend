package com.greenbelly.metraz.service;

import com.greenbelly.metraz.model.Cliente;
import com.greenbelly.metraz.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findOne(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
