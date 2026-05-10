package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.ProfessorRequestDTO;
import com.Unis.UniSystem.Model.Professor;
import com.Unis.UniSystem.Repository.ProfessorRepository;
import com.Unis.UniSystem.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@CrossOrigin("*")
public class ProfessorController {

    private final ProfessorRepository repository;
    private final ProfessorService service;

    public ProfessorController(
            ProfessorRepository repository,
            ProfessorService service
    ) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Professor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Professor findProfessor(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Professor salvar(@RequestBody ProfessorRequestDTO request) {
        return service.salvar(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Professor editar(@PathVariable Long id, @RequestBody ProfessorRequestDTO request){
        return service.editar(id, request);
    }
}