package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.DTO.AlunoRequestDTO;
import com.Unis.UniSystem.Model.Aluno;
import com.Unis.UniSystem.Model.Pessoa;
import com.Unis.UniSystem.Repository.AlunoRepository;
import com.Unis.UniSystem.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PessoaRepository pessoaRepository;

    public AlunoService(AlunoRepository alunoRepository, PessoaRepository pessoaRepository) {
        this.alunoRepository = alunoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Aluno salvar(AlunoRequestDTO request){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(request.getNome());
        pessoa.setCpf(request.getCpf());
        pessoa.setEmail(request.getEmail());
        pessoa.setTelefone(request.getTelefone());
        pessoa.setGenero(request.getGenero());
        pessoa.setDataNascimento(request.getDataNascimento());
    }

}
