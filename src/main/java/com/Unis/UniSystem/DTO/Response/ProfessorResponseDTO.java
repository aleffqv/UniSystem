package com.Unis.UniSystem.DTO.Response;

import com.Unis.UniSystem.DTO.Resumo.DepartamentoResumoDTO;
import com.Unis.UniSystem.DTO.Resumo.PessoaResumoDTO;
import com.Unis.UniSystem.DTO.Resumo.TurmaResumoDTO;

import java.util.List;

public class ProfessorResponseDTO {

    private Long id;

    private PessoaResumoDTO pessoa;

    private String titulacao;
    private String especialidade;

    private DepartamentoResumoDTO departamento;

    private List<TurmaResumoDTO> turmas;

    public ProfessorResponseDTO() {
    }

    public ProfessorResponseDTO(
            Long id,
            PessoaResumoDTO pessoa,
            String titulacao,
            String especialidade,
            DepartamentoResumoDTO departamento,
            List<TurmaResumoDTO> turmas
    ) {
        this.id = id;
        this.pessoa = pessoa;
        this.titulacao = titulacao;
        this.especialidade = especialidade;
        this.departamento = departamento;
        this.turmas = turmas;
    }

    public Long getId() {
        return id;
    }

    public PessoaResumoDTO getPessoa() {
        return pessoa;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public DepartamentoResumoDTO getDepartamento() {
        return departamento;
    }

    public List<TurmaResumoDTO> getTurmas() {
        return turmas;
    }
}
