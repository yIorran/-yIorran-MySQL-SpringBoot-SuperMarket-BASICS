//package com.example.pdv.application.controller;
//
//import com.example.pdv.application.model.Funcionario;
//import com.example.pdv.application.repository.FuncionarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/busca")
//public class LoginFuncionario {
//
//    @Autowired
//    FuncionarioRepository repositoryGen;
//
//    @PostMapping
//    public @ResponseBody ResponseEntity<Object> varreduraFuncionario(@RequestBody Integer matricula, @RequestBody Integer senha) {
//        Funcionario funcionario = new Funcionario(matricula, senha);
//        if(repositoryGen.equals(funcionario)){
//            System.out.println("Done");
//        }
//        return new ResponseEntity<Object>(repositoryGen.findAll(), HttpStatus.OK);
//    }
//}
