package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Service
public class ExcluirLoginFuncionario {

    @Autowired
    LoginFuncionarioEntitieRepository repositoryGen;

    @Autowired
    FuncionarioRepository repositoryGenFunc;

    @DeleteMapping(value = "/{matricula}")
    public ResponseEntity<FuncionarioEntitie> deletarFuncionario(@PathVariable Integer matricula){
        repositoryGen.deleteById(matricula);
        repositoryGenFunc.deleteById(matricula);
        return ResponseEntity.ok().build();
    }

}
