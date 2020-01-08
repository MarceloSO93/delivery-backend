package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.Cliente;
import com.greenbelly.metraz.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente insert(@RequestBody Cliente produto) {
        return service.insert(produto);
    }

    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        if (!id.equals(cliente.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(cliente));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
