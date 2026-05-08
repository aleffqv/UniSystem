package com.Unis.UniSystem.Model.Enums;

public enum Turno {
    MATUTINO("Matutino"),
    VERSPERTINO("Verspertino"),
    NOTURNO("Noturno");

    private String descricao;

    Turno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
