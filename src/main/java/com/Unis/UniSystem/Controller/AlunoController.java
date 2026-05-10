package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.AlunoRequestDTO;
import com.Unis.UniSystem.Model.Aluno;
import com.Unis.UniSystem.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listar(){
        return service.listar();
    }

    @PostMapping
    public Aluno salvar(@RequestBody AlunoRequestDTO request){
        return service.salvar(request);
    }

    @GetMapping("/{id}")
    public Aluno findAluno(@PathVariable Long id){
        return service.findAluno(id);
    }

    @PutMapping("/{id}")
    public Aluno editar(@PathVariable Long id, @RequestBody AlunoRequestDTO request){
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
