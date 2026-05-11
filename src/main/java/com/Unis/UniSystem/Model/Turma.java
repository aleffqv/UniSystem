package com.Unis.UniSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Professor professor;

    private String nome;
    private String sala;
    private String horario;
    private Integer nvagas;

    @OneToMany(mappedBy = "turma")
    @JsonIgnore
    private List<Matricula> matriculas = new ArrayList<>();

    public Turma() {
    }

    public Turma(Long id, Disciplina disciplina, Professor professor, String nome, String sala, String horario, Integer nvagas, List<Matricula> matriculas) {
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
        this.nome = nome;
        this.sala = sala;
        this.horario = horario;
        this.nvagas = nvagas;
        this.matriculas = matriculas;
    }

    public Long getId() {
        return id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getNvagas() {
        return nvagas;
    }

    public void setNvagas(Integer nvagas) {
        this.nvagas = nvagas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
