package com.Unis.UniSystem.DTO.Response;

import com.Unis.UniSystem.DTO.Resumo.CursoResumoDTO;

import java.util.List;

public class DepartamentoResponseDTO {

    private Long id;
    private String nome;

    private List<CursoResumoDTO> cursos;

    public DepartamentoResponseDTO() {
    }

    public DepartamentoResponseDTO(
            Long id,
            String nome,
            List<CursoResumoDTO> cursos
    ) {
        this.id = id;
        this.nome = nome;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<CursoResumoDTO> getCursos() {
        return cursos;
    }
}
