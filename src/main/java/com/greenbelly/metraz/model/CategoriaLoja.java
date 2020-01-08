package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORIAS_LOJAS")
public class CategoriaLoja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe o nome da categoria.")
    private String nome;

    private boolean privado;

    private ModalidadeTrabalho modalidadeTrabalho;

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

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public ModalidadeTrabalho getModalidadeTrabalho() {
        return modalidadeTrabalho;
    }

    public void setModalidadeTrabalho(ModalidadeTrabalho modalidadeTrabalho) {
        this.modalidadeTrabalho = modalidadeTrabalho;
    }
}
