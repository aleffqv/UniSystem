package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.DisciplinaRequestDTO;
import com.Unis.UniSystem.Model.Disciplina;
import com.Unis.UniSystem.Service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin("*")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Disciplina> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Disciplina findDisciplina(@PathVariable Long id){
        return service.findDisciplina(id);
    }

    @PostMapping
    public Disciplina salvar(@RequestBody DisciplinaRequestDTO request){
        return service.salvar(request);
    }

    @PutMapping("/{id}")
    public Disciplina salvar(@PathVariable Long id, @RequestBody DisciplinaRequestDTO request){
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
