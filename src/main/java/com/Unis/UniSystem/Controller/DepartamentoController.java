package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.Model.Departamento;
import com.Unis.UniSystem.Repository.DepartamentoRepository;
import com.Unis.UniSystem.Service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin("*")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Departamento> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> findDep(@PathVariable Long id){
        return service.findDep(id);
    }

    @PostMapping
    public Departamento salvar(@RequestBody Departamento departamento){
        return service.salvar(departamento);
    }

    @PutMapping("/{id}")
    public Departamento editar(@PathVariable Long id, @RequestBody Departamento departamentoAtualizado){
        return service.editar(id, departamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
