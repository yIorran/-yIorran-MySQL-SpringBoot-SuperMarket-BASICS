package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
@Service
public class AtualizaFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;

    @Autowired
    LoginFuncionarioEntitieRepository loginFuncionarioEntitieRepository;

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula,
                                                      @RequestBody FuncionarioEntitie funcionarioEntitie){
        return attFuncionario(matricula, funcionarioEntitie);
    }

    public ResponseEntity<Object> attFuncionario(Integer matricula, FuncionarioEntitie funcionarioEntitie) {
        LoginFuncionarioEntitie loginFuncionarioEntitie = new LoginFuncionarioEntitie(funcionarioEntitie.getMatricula(),
                funcionarioEntitie.getSenha());
        if(repositoryGen.findById(matricula).isPresent() && loginFuncionarioEntitieRepository.findById(matricula).isPresent()) {
            funcionarioEntitie.setMatricula(matricula);
            loginFuncionarioEntitie.setMatricula(matricula);
            repositoryGen.save(funcionarioEntitie);
            loginFuncionarioEntitieRepository.save(loginFuncionarioEntitie);
            return ResponseEntity.ok().body(funcionarioEntitie);
        }
        return ResponseEntity.notFound().build();
    }

}
