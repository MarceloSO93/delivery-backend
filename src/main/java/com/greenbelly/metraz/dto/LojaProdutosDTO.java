package com.greenbelly.metraz.dto;


import com.greenbelly.metraz.model.CategoriaLoja;
import com.greenbelly.metraz.model.Endereco;
import com.greenbelly.metraz.model.Loja;

public class LojaProdutosDTO {

    private Long id;
    private String nomeLoja;
    private String email;
    private boolean online;
    private String telefone;
    private CategoriaLoja categoriaLoja;
    private Endereco endereco;

    public LojaProdutosDTO(
            Long id,
            String nomeLoja,
            boolean online,
            String telefone,
            CategoriaLoja categoriaLoja,
            Endereco endereco
    ) {
        this.id = id;
        this.nomeLoja = nomeLoja;
        this.email = email;
        this.online = online;
        this.telefone = telefone;
        this.categoriaLoja = categoriaLoja;
        this.endereco = endereco;
    }

    public static LojaProdutosDTO convertOneDTO(Loja loja) {
        return new LojaProdutosDTO(
                loja.getId(),
                loja.getNome(),
                loja.isOnline(),
                loja.getTelefone(),
                loja.getCategoriaLoja(),
                loja.getEndereco()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CategoriaLoja getCategoriaLoja() {
        return categoriaLoja;
    }

    public void setCategoriaLoja(CategoriaLoja categoriaLoja) {
        this.categoriaLoja = categoriaLoja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
