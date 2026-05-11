package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.DTO.MatriculaRequestDTO;
import com.Unis.UniSystem.Model.Matricula;
import com.Unis.UniSystem.Service.MatriculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@CrossOrigin("*")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Matricula findMatricula(@PathVariable Long id){
        return service.findMatricula(id);
    }

    @PostMapping
    public Matricula salvar(@RequestBody MatriculaRequestDTO request){
        return service.salvar(request);
    }

    @PutMapping("/{id}")
    public Matricula editar(@PathVariable Long id, @RequestBody MatriculaRequestDTO request){
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
