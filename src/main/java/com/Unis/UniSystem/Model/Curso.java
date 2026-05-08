package com.Unis.UniSystem.Model;


import com.Unis.UniSystem.Model.Enums.Turno;
import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer cargaHoraria;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    private String status;
    private Integer periodos;

    @ManyToOne
    private Departamento departamento;

    public Curso(Long id, String nome, Integer cargaHoraria, Turno turno, String status, Integer periodos, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.turno = turno;
        this.status = status;
        this.periodos = periodos;
        this.departamento = departamento;
    }

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Integer periodos) {
        this.periodos = periodos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
