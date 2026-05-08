package com.Unis.UniSystem.Controller;

import com.Unis.UniSystem.Model.Departamento;
import com.Unis.UniSystem.Repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin("*")
public class DepartamentoController {

    private final DepartamentoRepository repository;

    public DepartamentoController(DepartamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Departamento> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> findDep(@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departamento salvar(@RequestBody Departamento departamento){
        return repository.save(departamento);
    }

    @PutMapping("/{id}")
    public Departamento editar(@PathVariable Long id, @RequestBody Departamento departamentoAtualizado){
        Departamento departamento = repository.findById(id).orElseThrow();

        departamento.setNome(departamentoAtualizado.getNome());

        return repository.save(departamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
