package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ARQUIVOS")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe a regiao AWS onde se encontra o bucket.")
    @Column(name = "regiao_aws")
    private String clientRegion;

    @NotNull(message = "Informe o nome do Bucket.")
    @Column(name = "bucket")
    private String bucketName;

    @NotNull(message = "Informe o nome da chave do obijeto.")
    @Column(name = "chave_obijeto")
    private String stringObjKeyNam;

    @NotNull(message = "Informe o nome da chave do arquivo.")
    @Column(name = "chave_arquivo")
    private String fileObjKeyName;

    @NotNull(message = "Informe o nome do arquivo.")
    @Column(name = "nome_arquivo")
    private String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientRegion() {
        return clientRegion;
    }

    public void setClientRegion(String clientRegion) {
        this.clientRegion = clientRegion;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getStringObjKeyNam() {
        return stringObjKeyNam;
    }

    public void setStringObjKeyNam(String stringObjKeyNam) {
        this.stringObjKeyNam = stringObjKeyNam;
    }

    public String getFileObjKeyName() {
        return fileObjKeyName;
    }

    public void setFileObjKeyName(String fileObjKeyName) {
        this.fileObjKeyName = fileObjKeyName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
