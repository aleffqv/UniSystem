package com.Unis.UniSystem.Service;

import com.Unis.UniSystem.Model.Departamento;
import com.Unis.UniSystem.Repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartamentoService {

    private DepartamentoRepository repository;

    public DepartamentoService(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public List<Departamento> listar(){
        return repository.findAll();
    }

    public ResponseEntity<Departamento> findDep(@PathVariable Long id){
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public Departamento salvar(@RequestBody Departamento departamento){
        return repository.save(departamento);
    }

    public Departamento editar(@PathVariable Long id, @RequestBody Departamento departamentoAtualizado){
        Departamento departamento = repository.findById(id).orElseThrow();

        departamento.setNome(departamentoAtualizado.getNome());

        return repository.save(departamento);
    }

    public void deletar(@PathVariable Long id){

        Departamento departamento = repository.findById(id).orElseThrow();

        if(!departamento.getCursos().isEmpty()){
            throw new RuntimeException("Departamento possui cursos");
        }

        repository.deleteById(id);
    }

}
