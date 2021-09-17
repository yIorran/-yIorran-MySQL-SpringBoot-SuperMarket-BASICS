package com.example.pdv.application.service;

import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExcluirLoginFuncionario {

    @Autowired
    LoginFuncionarioEntitieRepository repositoryGen;

    @Autowired
    FuncionarioRepository repositoryGenFunc;


    public ResponseEntity<LoginFuncionarioEntitie> deletarFuncionario(Integer matricula){
        repositoryGen.deleteById(matricula);
        repositoryGenFunc.deleteById(matricula);
        return ResponseEntity.ok().build();
    }

}
