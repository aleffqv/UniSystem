package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.AlunoRequestDTO;
import com.Unis.UniSystem.Model.Aluno;
import com.Unis.UniSystem.Model.Curso;
import com.Unis.UniSystem.Model.Pessoa;
import com.Unis.UniSystem.Repository.AlunoRepository;
import com.Unis.UniSystem.Repository.CursoRepository;
import com.Unis.UniSystem.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PessoaRepository pessoaRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, PessoaRepository pessoaRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.pessoaRepository = pessoaRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno findAluno(Long id){
        return alunoRepository.findById(id).orElseThrow();
    }


    public Aluno salvar(AlunoRequestDTO request){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(request.getNome());
        pessoa.setCpf(request.getCpf());
        pessoa.setEmail(request.getEmail());
        pessoa.setTelefone(request.getTelefone());
        pessoa.setGenero(request.getGenero());
        pessoa.setDataNascimento(request.getDataNascimento());
        pessoa.setStatus(request.getStatus());

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        Aluno aluno = new Aluno();

        aluno.setPessoa(pessoaSalva);

        return alunoRepository.save(aluno);
    }

    public Aluno editar(Long id, AlunoRequestDTO request){

        Aluno aluno = alunoRepository.findById(id).orElseThrow();

        Pessoa pessoa = aluno.getPessoa();

        pessoa.setNome(request.getNome());
        pessoa.setCpf(request.getCpf());
        pessoa.setEmail(request.getEmail());
        pessoa.setTelefone(request.getTelefone());
        pessoa.setGenero(request.getGenero());
        pessoa.setDataNascimento(request.getDataNascimento());
        pessoa.setStatus(request.getStatus());

        //pessoaRepository.save(pessoa);

        return alunoRepository.save(aluno);
    }

    public void deletar(Long id){

        Aluno aluno = alunoRepository.findById(id).orElseThrow();

        Pessoa pessoa = aluno.getPessoa();

        alunoRepository.delete(aluno);

        pessoaRepository.delete(pessoa);
    }

    public Aluno matricularAlunoCurso(Long alunoId, Long cursoId){

        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();

        if(aluno.getCurso() != null){
            throw new RuntimeException("Aluno já matriculado em curso");
        }

        aluno.setCurso(curso);
        return alunoRepository.save(aluno);
    }

}
