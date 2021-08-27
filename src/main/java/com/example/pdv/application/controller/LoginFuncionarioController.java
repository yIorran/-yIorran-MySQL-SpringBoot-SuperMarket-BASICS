package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;

    @RestController
    @RequestMapping("login")
    public class LoginFuncionarioController {

        @Autowired
        LoginFuncionarioEntitieRepository repositoryGen;

        @PostMapping("/save")
        public void salvarFuncionario(@RequestBody LoginFuncionarioEntitie loginFuncionario) {
            repositoryGen.save(loginFuncionario);
        }

        @GetMapping
        public ResponseEntity<Object> buscarFuncionario() {
            return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
        }

        @PutMapping("/attFunc/{matricula}")
        public LoginFuncionarioEntitie atualizaFuncionario(@PathVariable Integer matricula, @RequestBody LoginFuncionarioEntitie loginFuncionario) {
            return attFuncionario(matricula, loginFuncionario);
        }

        public LoginFuncionarioEntitie attFuncionario(Integer matricula, LoginFuncionarioEntitie loginFuncionario) {
            loginFuncionario.setMatricula(matricula);
            return repositoryGen.save(loginFuncionario);
        }

        @DeleteMapping(value = "/{id}")
        public void deletarFuncionario(@PathVariable Integer matricula) {
            repositoryGen.deleteById(matricula);
        }

        @PostMapping
        public void loginFuncionario(@RequestBody LoginFuncionarioEntitie loginFuncionario) {
            if (validaLogin(loginFuncionario)) {
                System.out.println("Login success");
            } else {
                System.out.println("Login failed");
            }
        }

        public boolean validaLogin(LoginFuncionarioEntitie loginFuncionario) {
            Boolean decisao = null;
            if (loginFuncionario.hashCode() == repositoryGen.findById(loginFuncionario.getMatricula()).hashCode()) {
                decisao = true;
            } else {
                decisao = false;
            }
            return decisao;
        }

        /*
        Nova rota adicionada: /login

        Próximo passo: Sincronizar os 2 bancos de dados para que haja a sincronicidade de dados
         */


    }

