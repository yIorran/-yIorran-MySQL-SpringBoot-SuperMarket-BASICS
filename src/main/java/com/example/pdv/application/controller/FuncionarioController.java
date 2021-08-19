package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

//    @Autowired
//    LoginCaixaImpl loginCaixaImpl;
//    @Autowired
//    Funcionario funcionario;

    @Autowired
    FuncionarioRepository repositoryGen;

    @PostMapping
    public void salvarFuncionario(@RequestBody Funcionario funcionario){
        repositoryGen.save(funcionario);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> buscarFuncionario(){
        return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
    }

    @PutMapping("/attFunc/{id}")
    public Funcionario atualizaFuncionario(@PathVariable("id") Integer id, @RequestBody Funcionario funcionario){
        return attFuncionario(id, funcionario);
    }

    public Funcionario attFuncionario(Integer id, Funcionario funcionario) {
        funcionario.setId(id);
        return repositoryGen.save(funcionario);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarFuncionario(@PathVariable("id") Integer id){
        repositoryGen.deleteById(id);
    }

}
