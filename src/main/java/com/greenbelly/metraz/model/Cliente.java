package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe o seu nome.")
    private String nome;

    @NotNull(message = "Informe seu numero para contato.")
    private String telefone;

    @NotNull(message = "Informe seu e-mail")
    @Email(message = "O e-mail informado não é valido")
    private String email;

    @NotEmpty(message = "Informe seu endereço")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
