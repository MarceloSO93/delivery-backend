package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.Pedido;
import com.greenbelly.metraz.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido-produtos")
public class PedidoResource {

    @Autowired
    private PedidoService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pedido insert(@RequestBody Pedido predidoProdutos) {
        return service.insert(predidoProdutos);
    }

    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> update(@PathVariable("id") Long id, @RequestBody Pedido predidoProdutos) {
        if (!id.equals(predidoProdutos.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(predidoProdutos));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Pedido findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
