package com.example.pdv.application.controller;

import com.example.pdv.application.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/del")
public class DeleteFuncionario {

    @Autowired
    FuncionarioRepository repositoryGen;

    @DeleteMapping(value = "/{id}")
    public void deletarFuncionario(@PathVariable("id") Integer id){
        repositoryGen.deleteById(id);
    }

}
