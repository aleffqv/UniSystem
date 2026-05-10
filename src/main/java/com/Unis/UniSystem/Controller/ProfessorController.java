package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.ProfessorRequestDTO;
import com.Unis.UniSystem.Model.Professor;
import com.Unis.UniSystem.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@CrossOrigin("*")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Professor findProfessor(@PathVariable Long id) {
        return service.findProfessor(id);
    }

    @PostMapping
    public Professor salvar(@RequestBody ProfessorRequestDTO request) {
        return service.salvar(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Professor editar(@PathVariable Long id, @RequestBody ProfessorRequestDTO request){
        return service.editar(id, request);
    }
}