package com.example.pdv.application.controller;

import com.example.pdv.application.model.FuncionarioEntitie;
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

        @Autowired
        FuncionarioRepository repositoryGenFunc;

        @PostMapping("/save")
        public ResponseEntity<LoginFuncionarioEntitie> salvarFuncionario(@RequestBody LoginFuncionarioEntitie loginFuncionario) {
            FuncionarioEntitie funcionarioEntitie = new FuncionarioEntitie(null, loginFuncionario.getMatricula(), loginFuncionario.getSenha());
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
        @GetMapping
        public ResponseEntity<Object> buscarFuncionario() {
            return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
        }
        @PutMapping("/{matricula}")
        public ResponseEntity<Object> atualizaFuncionario(@PathVariable Integer matricula, @RequestBody LoginFuncionarioEntitie loginFuncionario) {
            return attFuncionario(matricula, loginFuncionario);
        }

        public ResponseEntity<Object> attFuncionario(Integer matricula, LoginFuncionarioEntitie loginFuncionario) {
            if(repositoryGen.findById(matricula).isPresent()) {
                loginFuncionario.setMatricula(matricula);
                repositoryGen.save(loginFuncionario);
                return ResponseEntity.ok().body(loginFuncionario);
            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping(value = "/{matricula}")
        public void deletarFuncionario(@PathVariable Integer matricula) {
            repositoryGen.deleteById(matricula);
        }

        @PostMapping
        public void loginFuncionario(@RequestBody LoginFuncionarioEntitie loginFuncionario) {
            try {
                if (validaLogin(loginFuncionario)) {
                    System.out.println("Login success");
                } else {
                    System.out.println("Login failed, please check your login and password and try again.");
                    throw new AuthException("Login failed, please check your login and password and try again.");
                }
            } catch (AuthException e) {
                e.getMessage();
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
    }

