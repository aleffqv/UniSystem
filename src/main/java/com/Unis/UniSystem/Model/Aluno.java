package com.Unis.UniSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Matricula> matriculas = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(Long id, Pessoa pessoa, Curso curso, List<Matricula> matriculas) {
        this.id = id;
        this.pessoa = pessoa;
        this.curso = curso;
        this.matriculas = matriculas;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
