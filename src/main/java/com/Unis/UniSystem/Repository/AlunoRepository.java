package com.Unis.UniSystem.Repository;

import com.Unis.UniSystem.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
