package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENDERECOS")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe o estado.")
    private Estado estado;

    @NotNull(message = "Informe sua cidade.")
    private String cidade;

    @NotNull(message = "Informe seu bairro.")
    private String bairro;

    @NotNull(message = "Informe sua rua.")
    private String rua;

    private String cep;

    @Column(name = "numero_imovel")
    @NotNull(message = "Informe o numero de sua residencia.")
    private Long numeroImovel;

    private String complemento;

    private Long latitude;

    private Long longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getNumeroImovel() {
        return numeroImovel;
    }

    public void setNumeroImovel(Long numeroImovel) {
        this.numeroImovel = numeroImovel;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
}
