package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastraLoginFuncionario {

    @Autowired
    LoginFuncionarioEntitieRepository repositoryGen;

    @Autowired
    FuncionarioRepository repositoryGenFunc;

    public ResponseEntity<LoginFuncionarioEntitie> salvarFuncionario(LoginFuncionarioEntitie loginFuncionario) {
        FuncionarioEntitie funcionarioEntitie = new FuncionarioEntitie(null, loginFuncionario.getMatricula(),
                loginFuncionario.getSenha());
        if(repositoryGen.existsById(loginFuncionario.getMatricula())){
            System.out.println("Matricula já existente");
            ResponseEntity.badRequest().build();
        }
        else {
            repositoryGen.save(loginFuncionario);
            repositoryGenFunc.save(funcionarioEntitie);
            return ResponseEntity.ok().body(loginFuncionario);
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
