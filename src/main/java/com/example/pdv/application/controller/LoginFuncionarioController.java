package com.example.pdv.application.controller;

import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;

    @RestController
    @RequestMapping("/login")
    public class LoginFuncionarioController {

        @Autowired
        LoginFuncionarioEntitieRepository repositoryGen;

        @GetMapping
        public ResponseEntity<Object> buscarFuncionario() {
            return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
        }

    }

