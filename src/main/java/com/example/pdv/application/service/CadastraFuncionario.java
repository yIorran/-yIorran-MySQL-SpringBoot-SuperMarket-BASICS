package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CadastraFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;

    @Autowired
    LoginFuncionarioEntitieRepository loginFuncionarioEntitieRepository;

    public ResponseEntity<FuncionarioEntitie> salvaFuncionario(@RequestBody FuncionarioEntitie funcionarioEntitie){
        LoginFuncionarioEntitie loginFuncionarioEntitie = new LoginFuncionarioEntitie(funcionarioEntitie.getMatricula(),
                funcionarioEntitie.getSenha());
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
}
