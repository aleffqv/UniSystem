package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.DisciplinaRequestDTO;
import com.Unis.UniSystem.Model.Disciplina;
import com.Unis.UniSystem.Repository.CursoRepository;
import com.Unis.UniSystem.Repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final CursoRepository cursoRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository, CursoRepository cursoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Disciplina> listar(){
        return disciplinaRepository.findAll();
    }

    public Disciplina findDisciplina(Long id){
        return disciplinaRepository.findById(id).orElseThrow();
    }

    public Disciplina salvar(DisciplinaRequestDTO request){
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(request.getNome());
        disciplina.setCurso();
    }
}
