package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("login")
public class LoginFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;

    /*
    24/08 -
    Nesta classe estou tentando fazer a varredura dos itens contidos no banco de dados e comparar com os parametros obtidos via JSON
    Os parametros estao entrando corretamente, o OBJ funcionario esta igual ao banco mas o repositoryGen nao faz a filtragem
    Estou pensando em usar lambda para a varredura

    possiveis proximos passos:
    gerar uma lista List do tipo repositoryGen para copiar os valores do banco nela e usa-la para comparar com o objeto funcionario via JSON
     */
/*
25/08 -
Houve avanço no processo de login, agora preciso fazer com que o "id" nao seja requerido na URL e o login seja feito por meio de matricula e senha

Para o login via postman é necessário passar os dados via JSON:

{
        "nome": "Tomas Leme Vieira Filho",
        "matricula": 2313,
        "senha": 563145,
        "id":4
}

URL: localhost:8081/login/{id}

 */
    @PostMapping
    public void loginFuncionario(@RequestBody Funcionario funcionario)  {

        try {
//        Iterable<Funcionario> repositoryGenLocal = repositoryGen.findAll().forEach(funcionario1 -> funcionario);
            if (funcionario.hashCode() == repositoryGen.findById(funcionario.getId()).hashCode()) {
                System.out.println("Login success");
                System.out.println("Bem vindo(a) " + funcionario.getNome() + "!");
            } else {
                System.out.println("Login failed");
//                System.out.println(funcionario.hashCode());
//                System.out.println(repositoryGen.hashCode());
                System.out.println("Usuário ou senha inválidos");
                throw new AuthException("Usuário ou senha inválidos");
            }
        } catch (AuthException e) {
            e.getMessage();
        }
    }
    }
//    Optional<Funcionario> funcionarioExistente;
//        for (int index = 0; index < repositoryGen.count(); index++) {
//        funcionarioExistente = repositoryGen.findById(index);
//        if (funcionario.hashCode() == repositoryGen.findById(funcionario.getId()).hashCode()) {
////            if (funcionario.hashCode() == repositoryGen.hashCode()) {
//        System.out.println("Login success");
//        System.out.println("Bem vindo " + funcionario.getNome() + "!");
//        } else {
//        System.out.println("Login failed");
////            System.out.println(repositoryGen.findAll().toString());
//        System.out.println(funcionario.hashCode());
//        System.out.println(repositoryGen.hashCode());
//        System.out.println(repositoryGen);
////            System.out.println(repositoryGen.findById(4));
//        }
//        break;
//        }
//____________________________________________________________________________________________________________________
//    Optional<Funcionario> funcionarioExistente;
//        for (int index = 0; index < repositoryGen.count(); index++) {
//        funcionarioExistente = repositoryGen.findById(index);
//        if (funcionarioExistente.isPresent()) {
////            if (funcionario.hashCode() == repositoryGen.hashCode()) {
//        System.out.println("Login success");
//        System.out.println("Bem vindo " + funcionario.getNome() + "!");
//        } else {
//        System.out.println("Login failed");
////            System.out.println(repositoryGen.findAll().toString());
//        System.out.println(funcionario.hashCode());
//        System.out.println(repositoryGen.hashCode());
//        System.out.println(repositoryGen);
////            System.out.println(repositoryGen.findById(4));
//        }
//        break;
//        }
