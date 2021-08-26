package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repositoryGen;

    @PostMapping
    public void salvarFuncionario(@RequestBody Funcionario funcionario){
        repositoryGen.save(funcionario);
    }

    @GetMapping
    public ResponseEntity<Object> buscarFuncionario(){
        return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Funcionario atualizaFuncionario(Integer id, @RequestBody Funcionario funcionario){
        return attFuncionario(id, funcionario);
    }

    public Funcionario attFuncionario(Integer id, Funcionario funcionario) {
        funcionario.setId(id);
        return repositoryGen.save(funcionario);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarFuncionario(@PathVariable Integer id){
        repositoryGen.deleteById(id);
    }

}
