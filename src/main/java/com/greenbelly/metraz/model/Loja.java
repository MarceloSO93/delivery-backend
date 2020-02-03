package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "LOJAS")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "De um nome para sua loja.")
    @Size(min = 1, max = 50, message = "O nome da sua Loja deve conter no maximo 50 caracteres.")
    private String nome;

    @NotNull(message = "Informe um numero para contato.")
    private String telefone;

    private boolean online;

    @NotNull(message = "Informe uma categoria.")
    @OneToOne
    private CategoriaLoja categoriaLoja;

    @NotNull(message = "Informe o responsavel.")
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario responsavel;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "loja"
    )
    private List<Usuario> usuarios;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "loja"
    )
    private List<Produto> produtos;

    @Basic(fetch = FetchType.LAZY)
    private byte[] logo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public CategoriaLoja getCategoriaLoja() {
        return categoriaLoja;
    }

    public void setCategoriaLoja(CategoriaLoja categoriaLoja) {
        this.categoriaLoja = categoriaLoja;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
