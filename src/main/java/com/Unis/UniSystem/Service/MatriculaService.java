package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.MatriculaRequestDTO;
import com.Unis.UniSystem.Model.Aluno;
import com.Unis.UniSystem.Model.Matricula;
import com.Unis.UniSystem.Model.Turma;
import com.Unis.UniSystem.Repository.AlunoRepository;
import com.Unis.UniSystem.Repository.MatriculaRepository;
import com.Unis.UniSystem.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public List<Matricula> listar(){
        return matriculaRepository.findAll();
    }

    public Matricula findMatricula(Long id){
        return matriculaRepository.findById(id).orElseThrow();
    }

    public Matricula salvar(MatriculaRequestDTO request) {
        Matricula matricula = new Matricula();

        matricula.setDataMatricula(request.getDataMatricula());

        Aluno aluno = alunoRepository.findById(request.getAlunoId()).orElseThrow();
        Turma turma = turmaRepository.findById(request.getTurmaId()).orElseThrow();

        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        return matriculaRepository.save(matricula);
    }

    public Matricula editar(Long id, MatriculaRequestDTO request){
        Matricula matricula = matriculaRepository.findById(id).orElseThrow();

        matricula.setDataMatricula(request.getDataMatricula());

        Aluno aluno = alunoRepository.findById(request.getAlunoId()).orElseThrow();
        Turma turma = turmaRepository.findById(request.getTurmaId()).orElseThrow();

        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        return matriculaRepository.save(matricula);
    }

    public void deletar(Long id){
        Matricula matricula = matriculaRepository.findById(id).orElseThrow();

        matriculaRepository.delete(matricula);
    }
}
