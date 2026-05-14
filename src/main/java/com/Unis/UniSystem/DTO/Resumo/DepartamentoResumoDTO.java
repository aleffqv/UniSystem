package com.Unis.UniSystem.DTO.Resumo;

public class DepartamentoResumoDTO {

    private Long id;
    private String nome;

    public DepartamentoResumoDTO() {
    }

    public DepartamentoResumoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
