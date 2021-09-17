package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExcluirFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;

    @Autowired
    LoginFuncionarioEntitieRepository loginFuncionarioEntitieRepository;

    public ResponseEntity<FuncionarioEntitie> deletarFuncionario(Integer matricula){
        repositoryGen.deleteById(matricula);
        loginFuncionarioEntitieRepository.deleteById(matricula);
        return ResponseEntity.ok().build();
    }

}
