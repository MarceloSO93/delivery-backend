package com.greenbelly.metraz.model;


public enum TipoPagamento {

    CARTAO(1), DINHEIRO(2);

    private int value;

    TipoPagamento(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
