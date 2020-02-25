package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.dto.ProdutoDTO;
import com.greenbelly.metraz.model.Produto;
import com.greenbelly.metraz.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Produto insert(@RequestBody Produto Produto) {
        return service.insert(Produto);
    }


    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody Produto Produto) {
        if (!id.equals(Produto.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(Produto));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProdutoDTO findOne(@PathVariable("id") Long id) {
        return ProdutoDTO.convertOneDTO(service.findOne(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/find-by-loja",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> findByIdLoja(@RequestParam("id") Long id) {
        return service.findByIdLoja(id);
    }

    @PutMapping(path = "/image/{id}")
    public String saveFoto(@PathVariable("id") Long id, @RequestParam MultipartFile foto) throws IOException {
        return service.saveImage(id, foto.getBytes());
    }

    @GetMapping(path = "/image/{id}")
    public ResponseEntity<String> getFoto(@PathVariable("id") Long id) {
        String fotoBase64 = service.getImagem(id);
        return fotoBase64 != null ?
                ResponseEntity.ok(fotoBase64) :
                ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
