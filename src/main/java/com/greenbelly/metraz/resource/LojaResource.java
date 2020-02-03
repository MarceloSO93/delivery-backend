package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.dto.LojaProdutosDTO;
import com.greenbelly.metraz.model.Loja;
import com.greenbelly.metraz.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loja")
public class LojaResource {

    @Autowired
    private LojaService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Loja insert(@RequestBody Loja Loja) {
        return service.insert(Loja);
    }

    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Loja> update(@PathVariable("id") Long id, @RequestBody Loja Loja) {
        if (!id.equals(Loja.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(Loja));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LojaProdutosDTO findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LojaProdutosDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/categoria",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LojaProdutosDTO> findByIdCategoria(@RequestParam("id") Long id) {
        return service.findByIdCAtegoria(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
