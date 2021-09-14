package com.example.pdv.application.controller;

import com.example.pdv.application.model.FuncionarioEntitie;
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
    public ResponseEntity<FuncionarioEntitie> salvaFuncionario(@RequestBody FuncionarioEntitie funcionarioEntitie){
        LoginFuncionarioEntitie loginFuncionarioEntitie = new LoginFuncionarioEntitie(funcionarioEntitie.getMatricula(), funcionarioEntitie.getSenha());
        if(repositoryGen.existsById(funcionarioEntitie.getMatricula())){
            System.out.println("Matricula já existente");
            ResponseEntity.badRequest().build();
        }
        else {
            repositoryGen.save(funcionarioEntitie);
            loginFuncionarioEntitieRepository.save(loginFuncionarioEntitie);
            return ResponseEntity.ok().body(funcionarioEntitie);
        }
        return ResponseEntity.unprocessableEntity().build();
    }
    @GetMapping
    public ResponseEntity<Object> buscarFuncionario(){
        return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula, @RequestBody FuncionarioEntitie funcionarioEntitie){
        return attFuncionario(matricula, funcionarioEntitie);
    }

    public ResponseEntity<Object> attFuncionario(Integer matricula, FuncionarioEntitie funcionarioEntitie) {
        LoginFuncionarioEntitie loginFuncionarioEntitie = new LoginFuncionarioEntitie(funcionarioEntitie.getMatricula(), funcionarioEntitie.getSenha());
        if(repositoryGen.findById(matricula).isPresent()) {
            funcionarioEntitie.setMatricula(matricula);
            repositoryGen.save(funcionarioEntitie);
            loginFuncionarioEntitieRepository.save(loginFuncionarioEntitie);
            return ResponseEntity.ok().body(funcionarioEntitie);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{matricula}")
    public ResponseEntity<FuncionarioEntitie> deletarFuncionario(@PathVariable Integer matricula){
        repositoryGen.deleteById(matricula);
        return ResponseEntity.ok().build();
    }

}
