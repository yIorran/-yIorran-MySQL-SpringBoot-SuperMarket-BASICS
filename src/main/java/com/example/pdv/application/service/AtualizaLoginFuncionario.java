package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class AtualizaLoginFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;

    @Autowired
    LoginFuncionarioEntitieRepository loginFuncionarioEntitieRepository;

    public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula, @RequestBody
            LoginFuncionarioEntitie loginFuncionario) {
        return attFuncionario(matricula, loginFuncionario);
    }

    public ResponseEntity<Object> attFuncionario(Integer matricula, LoginFuncionarioEntitie loginFuncionario) {
        FuncionarioEntitie funcionarioEntitie = new FuncionarioEntitie(null,loginFuncionario.getMatricula(), loginFuncionario.getSenha());
        if(loginFuncionarioEntitieRepository.findById(matricula).isPresent() && repositoryGen.findById(matricula).isPresent()) {
            funcionarioEntitie.setMatricula(matricula);
            funcionarioEntitie.setNome(repositoryGen.findById(matricula).get().getNome());
            loginFuncionario.setMatricula(matricula);
            loginFuncionarioEntitieRepository.save(loginFuncionario);
            repositoryGen.save(funcionarioEntitie);
            return ResponseEntity.ok().body(loginFuncionario);
        }
        return ResponseEntity.notFound().build();
    }
}
