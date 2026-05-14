package com.Unis.UniSystem.DTO.Response;

import com.Unis.UniSystem.DTO.Resumo.CursoResumoDTO;
import com.Unis.UniSystem.DTO.Resumo.DisciplinaResumoDTO;

import java.util.List;

public class CursoResponseDTO {

    private Long id;

    private String nome;

    private List<DisciplinaResumoDTO> disciplinas;


}
