package com.example.pdv.application.controller;

import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import com.example.pdv.application.service.AtualizaLoginFuncionario;
import com.example.pdv.application.service.CadastraLoginFuncionario;
import com.example.pdv.application.service.ExcluirLoginFuncionario;
import com.example.pdv.application.service.LogonLoginFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/login")
    public class LoginFuncionarioController {

        @Autowired
        LoginFuncionarioEntitieRepository repositoryGen;

        @Autowired
        CadastraLoginFuncionario cadastraLoginFuncionario;

        @Autowired
        AtualizaLoginFuncionario atualizaLoginFuncionario;

        @Autowired
        ExcluirLoginFuncionario excluirLoginFuncionario;

        @Autowired
        LogonLoginFuncionario logonLoginFuncionario;

        @PostMapping("/save")
        public ResponseEntity<LoginFuncionarioEntitie> salvarFuncionario(@RequestBody LoginFuncionarioEntitie loginFuncionario){
            cadastraLoginFuncionario.salvarFuncionario(loginFuncionario);
            return ResponseEntity.ok().build();
        }

        @PutMapping("/{matricula}")
        public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula, @RequestBody
                LoginFuncionarioEntitie loginFuncionario){
            return atualizaLoginFuncionario.atualizaFuncionario(matricula, loginFuncionario);
        }

        @DeleteMapping(value = "/{matricula}")
        public ResponseEntity<LoginFuncionarioEntitie> deletarFuncionario(@PathVariable Integer matricula){
            return excluirLoginFuncionario.deletarFuncionario(matricula);
        }

        @PostMapping
        public void loginFuncionario(@RequestBody LoginFuncionarioEntitie loginFuncionario){
            logonLoginFuncionario.loginFuncionario(loginFuncionario);
        }

        @GetMapping
        public ResponseEntity<Object> buscarFuncionario() {
            return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
        }

    }

