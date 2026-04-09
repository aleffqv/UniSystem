package com.Unis.UniSystem.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNasc;
    private String email;
    private String telefone;
    private String matricula;
    private String status;

    public Aluno (){

    }


    public Aluno(String nome, String cpf, Date dataNasc, String email, String telefone, String matricula, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getStatus() {
        return status;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
