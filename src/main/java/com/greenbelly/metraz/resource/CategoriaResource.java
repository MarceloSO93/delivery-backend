package com.greenbelly.metraz.resource;

import com.greenbelly.metraz.model.CategoriaLoja;
import com.greenbelly.metraz.model.ModalidadeTrabalho;
import com.greenbelly.metraz.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("categorias-lojas")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoriaLoja> findAll(){
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CategoriaLoja insert(@RequestBody CategoriaLoja categoriaLoja) {
        return service.insert(categoriaLoja);
    }

    @PutMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaLoja> update(@PathVariable("id") Long id, @RequestBody CategoriaLoja categoriaLoja) {
        if (!id.equals(categoriaLoja.getId()))
            return ResponseEntity
                    .badRequest().build();

        return ResponseEntity.ok(service.update(categoriaLoja));
    }

    @GetMapping(path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoriaLoja findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(path = "/modalidade",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoriaLoja> findByModalidadeTrabalho(@RequestParam("modalidade") ModalidadeTrabalho modalidadeTrabalho) {
        return service.findByModalidadeTrabalho(modalidadeTrabalho);
    }

    @PutMapping(path = "/image/{id}")
    public String saveFoto(@PathVariable("id") Long id, @RequestParam MultipartFile foto) throws IOException {
        return service.saveImage(id, foto.getBytes());
    }

    @GetMapping(path = "/image/{id}")
    public ResponseEntity<String> getFoto(@PathVariable("id") Long id) {
        String fotoBase64 = service.getFoto(id);
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
