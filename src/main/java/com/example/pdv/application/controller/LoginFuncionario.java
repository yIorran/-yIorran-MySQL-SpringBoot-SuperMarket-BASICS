package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;
/*
Nesta classe estou tentando fazer a varredura dos itens contidos no banco de dados e comparar com os parametros obtidos via JSON
Os parametros estao entrando corretamente, o OBJ funcionario esta igual ao banco mas o repositoryGen nao faz a filtragem
Estou pensando em usar lambda para a varredura

possiveis proximos passos:
gerar uma lista List do tipo repositoryGen para copiar os valores do banco nela e usa-la para comparar com o objeto funcionario via JSON
 */
    @PostMapping
    public void loginFuncionario(@RequestBody Funcionario funcionario){
//        if(repositoryGen.findAll().toString().equals(funcionario)){
                if(funcionario.equals(repositoryGen.findById(4))){

                    System.out.println("Login success");
        }
        else {
            System.out.println("Login failed");
            System.out.println(repositoryGen.findAll().toString());
            System.out.println(funcionario.toString());
            System.out.println(repositoryGen.findById(4));
        }
    }

}
