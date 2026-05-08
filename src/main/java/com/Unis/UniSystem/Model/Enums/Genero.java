package com.Unis.UniSystem.Model.Enums;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_ESPECIFICAR("Não especificar");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
