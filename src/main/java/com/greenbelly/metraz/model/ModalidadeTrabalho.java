package com.greenbelly.metraz.model;

public enum ModalidadeTrabalho {

    VENDAS_PRODUTOS(1), PRESTADOR_SERVICOS(2), LOCACAO_BENS(3);

    private int value;

    ModalidadeTrabalho(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
