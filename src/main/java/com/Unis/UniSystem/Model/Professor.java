package com.Unis.UniSystem.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professores")
public class Professor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    private String titulacao;
    private String especialidade;

    @ManyToOne
    private Departamento departamento;

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<Turma> turmas;

    public Professor() {
    }

    public Professor(Long id, Pessoa pessoa, String titulacao, String especialidade, Departamento departamento, List<Turma> turmas) {
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
