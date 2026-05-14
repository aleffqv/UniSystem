package com.Unis.UniSystem.DTO.Resumo;

import com.Unis.UniSystem.Model.Enums.Genero;
import com.Unis.UniSystem.Model.Enums.Status;

import java.time.LocalDate;

public class PessoaResumoDTO {

    private String nome;
    private String cpf;
    private Genero genero;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Status status;

    public PessoaResumoDTO() {
    }

    public PessoaResumoDTO(String nome, String cpf, Genero genero, String email, String telefone, LocalDate dataNascimento, Status status) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Status getStatus() {
        return status;
    }
}
