package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;

import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repositoryGen;

    @Autowired
    LoginFuncionarioEntitieRepository loginFuncionarioEntitieRepository;

    @PostMapping
    public ResponseEntity<Funcionario> salvaFuncionario(@RequestBody Funcionario funcionario){
        LoginFuncionarioEntitie loginFuncionarioEntitie = new LoginFuncionarioEntitie(funcionario.getMatricula(), funcionario.getSenha());
        if(repositoryGen.existsById(funcionario.getMatricula())){
            System.out.println("Matricula já existente");
            ResponseEntity.badRequest().build();
        }
        else {
            repositoryGen.save(funcionario);
            loginFuncionarioEntitieRepository.save(loginFuncionarioEntitie);
            return ResponseEntity.ok().body(funcionario);
        }
        return ResponseEntity.unprocessableEntity().build();
    }
    @GetMapping
    public ResponseEntity<Object> buscarFuncionario(){
        return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula, @RequestBody Funcionario funcionario){
        return attFuncionario(matricula, funcionario);
    }

    public ResponseEntity<Object> attFuncionario(Integer matricula, Funcionario funcionario) {
        if(repositoryGen.findById(matricula).isPresent()) {
            funcionario.setMatricula(matricula);
            repositoryGen.save(funcionario);
            return ResponseEntity.ok().body(funcionario);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{matricula}")
    public ResponseEntity<Funcionario> deletarFuncionario(@PathVariable Integer matricula){
        repositoryGen.deleteById(matricula);
        return ResponseEntity.ok().build();
    }

}
