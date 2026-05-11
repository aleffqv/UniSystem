package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.TurmaRequestDTO;
import com.Unis.UniSystem.Model.Turma;
import com.Unis.UniSystem.Service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@CrossOrigin("*")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Turma> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Turma findTurma(@PathVariable Long id){
        return service.findTurma(id);
    }

    @PostMapping
    public Turma salvar(@RequestBody TurmaRequestDTO request){
        return service.salvar(request);
    }

    @PutMapping("/{id}")
    public Turma editar(@PathVariable Long id, @RequestBody TurmaRequestDTO request){
        return service.editar(id, request);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
