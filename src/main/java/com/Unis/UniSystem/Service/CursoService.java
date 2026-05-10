package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.CursoRequestDTO;
import com.Unis.UniSystem.Model.Curso;
import com.Unis.UniSystem.Model.Departamento;
import com.Unis.UniSystem.Model.Professor;
import com.Unis.UniSystem.Repository.CursoRepository;
import com.Unis.UniSystem.Repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final DepartamentoRepository departamentoRepository;

    public CursoService(CursoRepository cursoRepository, DepartamentoRepository departamentoRepository) {
        this.cursoRepository = cursoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public List<Curso> listar(){
        return cursoRepository.findAll();
    }

    public Curso findCurso(Long id){
        return cursoRepository.findById(id).orElseThrow();
    }

    public Curso salvar(CursoRequestDTO request){
        Curso curso = new Curso();

        curso.setNome(request.getNome());
        curso.setCargaHoraria(request.getCargaHoraria());
        curso.setPeriodos(request.getPeriodos());
        curso.setTurno(request.getTurno());

        Departamento departamento = departamentoRepository.findById(request.getDepartamentoId()).orElseThrow();
        curso.setDepartamento(departamento);
        return cursoRepository.save(curso);
    }

    public Curso editar(Long id, CursoRequestDTO request){
        Curso curso = cursoRepository.findById(id).orElseThrow();

        curso.setNome(request.getNome());
        curso.setCargaHoraria(request.getCargaHoraria());
        curso.setPeriodos(request.getPeriodos());
        curso.setTurno(request.getTurno());

        Departamento departamento = departamentoRepository.findById(id).orElseThrow();
        curso.setDepartamento(departamento);

        return cursoRepository.save(curso);

    }

    public void deletar(Long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();

        if(!curso.getDisciplinas().isEmpty()){
            throw new RuntimeException("O curso possui disciplinas");
        }

        cursoRepository.delete(curso);
    }
}
