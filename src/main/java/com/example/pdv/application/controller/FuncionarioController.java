package com.example.pdv.application.controller;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;

import com.example.pdv.application.service.AtualizaFuncionario;
import com.example.pdv.application.service.CadastraFuncionario;
import com.example.pdv.application.service.ExcluirFuncionario;
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
    CadastraFuncionario cadastraFuncionario;

    @Autowired
    AtualizaFuncionario atualizaFuncionario;

    @Autowired
    ExcluirFuncionario excluirFuncionario;


    @PostMapping
    public ResponseEntity<FuncionarioEntitie> salvarFuncionario(@RequestBody FuncionarioEntitie funcionarioEntitie){
            cadastraFuncionario.salvaFuncionario(funcionarioEntitie);
        return new ResponseEntity<FuncionarioEntitie>(HttpStatus.OK);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula,
                                                      @RequestBody FuncionarioEntitie funcionarioEntitie){
        return atualizaFuncionario.atualizaFuncionario(matricula, funcionarioEntitie);
    }

    @DeleteMapping(value = "/{matricula}")
    public ResponseEntity<FuncionarioEntitie> deletarFuncionario(@PathVariable Integer matricula){
        excluirFuncionario.deletarFuncionario(matricula);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Object> buscarFuncionario(){
        return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
    }
}
