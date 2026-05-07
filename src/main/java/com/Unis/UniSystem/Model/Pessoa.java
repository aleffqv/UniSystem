package com.Unis.UniSystem.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;


}
