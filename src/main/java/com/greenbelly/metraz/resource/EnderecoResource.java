package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.Endereco;
import com.greenbelly.metraz.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Endereco insert(@RequestBody Endereco endereco) {
        return service.insert(endereco);
    }

    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> update(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        if (!id.equals(endereco.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(endereco));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Endereco findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Endereco> findAll(){
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
