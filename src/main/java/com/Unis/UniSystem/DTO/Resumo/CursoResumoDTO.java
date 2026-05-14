package com.Unis.UniSystem.DTO.Resumo;

public class CursoResumoDTO {

    private Long id;
    private String nome;

    public CursoResumoDTO() {
    }

    public CursoResumoDTO(Long id, String nome) {
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