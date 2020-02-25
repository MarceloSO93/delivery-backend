package com.greenbelly.metraz.dto;


import com.greenbelly.metraz.model.Produto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private Long id;
    private String descricao;
    private String nome;
    private BigDecimal valor;
    private String marca;
    private byte[] imagem;

    public ProdutoDTO() {
    }

    private ProdutoDTO(Long id, String descricao, String nome, BigDecimal valor, byte[] imagem) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.valor = valor;
        this.imagem = imagem;
    }

    public static ProdutoDTO convertOneDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getDescricao(),
                produto.getNome(),
                produto.getValor(),
                produto.getImagem()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
