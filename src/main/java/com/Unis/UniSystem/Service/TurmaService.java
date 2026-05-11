package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.TurmaRequestDTO;
import com.Unis.UniSystem.Model.Disciplina;
import com.Unis.UniSystem.Model.Professor;
import com.Unis.UniSystem.Model.Turma;
import com.Unis.UniSystem.Repository.DisciplinaRepository;
import com.Unis.UniSystem.Repository.ProfessorRepository;
import com.Unis.UniSystem.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

    public TurmaService(TurmaRepository turmaRepository, DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository) {
        this.turmaRepository = turmaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    public List<Turma> listar(){
        return turmaRepository.findAll();
    }

    public Turma findTurma(Long id){
        return turmaRepository.findById(id).orElseThrow();
    }

    public Turma salvar(TurmaRequestDTO request){
        Turma turma = new Turma();

        turma.setNome(request.getNome());
        turma.setSala(request.getSala());
        turma.setHorario(request.getHorario());
        turma.setNvagas(request.getNvagas());

        Disciplina disciplina = disciplinaRepository.findById(request.getDisciplinaId()).orElseThrow();
        Professor professor = professorRepository.findById(request.getProfessorId()).orElseThrow();

        turma.setDisciplina(disciplina);
        turma.setProfessor(professor);

        return turmaRepository.save(turma);
    }

    public Turma editar(Long id, TurmaRequestDTO request){
        Turma turma = turmaRepository.findById(id).orElseThrow();

        turma.setNome(request.getNome());
        turma.setSala(request.getSala());
        turma.setHorario(request.getHorario());
        turma.setNvagas(request.getNvagas());

        Disciplina disciplina = disciplinaRepository.findById(request.getDisciplinaId()).orElseThrow();
        Professor professor = professorRepository.findById(request.getProfessorId()).orElseThrow();

        turma.setDisciplina(disciplina);
        turma.setProfessor(professor);

        return turmaRepository.save(turma);
    }

    public void deletar(Long id){
        Turma turma = turmaRepository.findById(id).orElseThrow();

        if(!turma.getMatriculas().isEmpty()){
            throw new RuntimeException("Turma com matriculas ativas");
        }

        turmaRepository.delete(turma);
    }
}
