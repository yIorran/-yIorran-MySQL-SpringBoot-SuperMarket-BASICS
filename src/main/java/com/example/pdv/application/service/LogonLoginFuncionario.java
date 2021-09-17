package com.example.pdv.application.service;

import com.example.pdv.application.model.LoginFuncionarioEntitie;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.LoginFuncionarioEntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;
@RestController
@RequestMapping("/login")
@Service
public class LogonLoginFuncionario {

    @Autowired
    LoginFuncionarioEntitieRepository repositoryGen;

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
