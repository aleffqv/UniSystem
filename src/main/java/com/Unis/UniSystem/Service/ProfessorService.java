package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.ProfessorRequestDTO;
import com.Unis.UniSystem.Model.Departamento;
import com.Unis.UniSystem.Model.Pessoa;
import com.Unis.UniSystem.Model.Professor;
import com.Unis.UniSystem.Repository.DepartamentoRepository;
import com.Unis.UniSystem.Repository.PessoaRepository;
import com.Unis.UniSystem.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final PessoaRepository pessoaRepository;
    private final DepartamentoRepository departamentoRepository;

    public ProfessorService(
            ProfessorRepository professorRepository,
            PessoaRepository pessoaRepository,
            DepartamentoRepository departamentoRepository
    ) {
        this.professorRepository = professorRepository;
        this.pessoaRepository = pessoaRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    public Professor findProfessor(Long id){
        return professorRepository.findById(id).orElseThrow();
    }

    public Professor salvar(ProfessorRequestDTO request) {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(request.getNome());
        pessoa.setCpf(request.getCpf());
        pessoa.setGenero(request.getGenero());
        pessoa.setEmail(request.getEmail());
        pessoa.setTelefone(request.getTelefone());
        pessoa.setDataNascimento(request.getDataNascimento());
        pessoa.setStatus(request.getStatus());

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        Departamento departamento = departamentoRepository.findById(request.getDepartamentoId()).orElseThrow();

        Professor professor = new Professor();

        professor.setPessoa(pessoaSalva);
        professor.setEspecialidade(request.getEspecializacao());
        professor.setTitulacao(request.getTitulacao());
        professor.setDepartamento(departamento);

        return professorRepository.save(professor);
    }

    public Professor editar(Long id, ProfessorRequestDTO request){

        Professor professor = professorRepository.findById(id).orElseThrow();

        Pessoa pessoa = professor.getPessoa();

        pessoa.setNome(request.getNome());
        pessoa.setCpf(request.getCpf());
        pessoa.setGenero(request.getGenero());
        pessoa.setEmail(request.getEmail());
        pessoa.setTelefone(request.getTelefone());
        pessoa.setDataNascimento(request.getDataNascimento());
        pessoa.setStatus(request.getStatus());

        pessoaRepository.save(pessoa);

        return professorRepository.save(professor);
    }

    public void deletar(Long id){

        Professor professor = professorRepository.findById(id).orElseThrow();

        Pessoa pessoa = professor.getPessoa();

        professorRepository.delete(professor);

        pessoaRepository.delete(pessoa);
    }


}