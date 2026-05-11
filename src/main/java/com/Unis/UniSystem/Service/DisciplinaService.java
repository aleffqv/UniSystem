package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.DisciplinaRequestDTO;
import com.Unis.UniSystem.Model.Curso;
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
        disciplina.setCargaHoraria(request.getCargaHoraria());
        disciplina.setPeriodo(request.getPeriodo());

        Curso curso = cursoRepository.findById(request.getCursoId()).orElseThrow();

        disciplina.setCurso(curso);

        return disciplinaRepository.save(disciplina);
    }

    public Disciplina editar(Long id, DisciplinaRequestDTO request){

        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow();

        disciplina.setNome(request.getNome());
        disciplina.setCargaHoraria(request.getCargaHoraria());
        disciplina.setPeriodo(request.getPeriodo());

        Curso curso = cursoRepository.findById(request.getCursoId()).orElseThrow();

        disciplina.setCurso(curso);

        return disciplinaRepository.save(disciplina);

    }

    public void deletar(Long id){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow();

        if(!disciplina.getTurmas().isEmpty()){
            throw new RuntimeException("A disciplina possui turmas ativas");
        }

        disciplinaRepository.delete(disciplina);
    }
}
