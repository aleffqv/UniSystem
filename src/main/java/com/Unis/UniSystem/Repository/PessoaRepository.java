package com.Unis.UniSystem.Repository;

import com.Unis.UniSystem.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
