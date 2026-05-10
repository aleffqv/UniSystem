package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.CursoRequestDTO;
import com.Unis.UniSystem.Model.Curso;
import com.Unis.UniSystem.Service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@CrossOrigin("*")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Curso> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Curso findCurso(@PathVariable Long id){
        return service.findCurso(id);
    }

    @PostMapping
    public Curso salvar(@RequestBody CursoRequestDTO request){
        return service.salvar(request);
    }

    @PutMapping("/{id}")
    public Curso editar(@PathVariable Long id, @RequestBody CursoRequestDTO request){
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
