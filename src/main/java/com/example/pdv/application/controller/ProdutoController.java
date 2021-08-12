package com.example.pdv.application.controller;

import com.example.pdv.application.model.Produto;
import com.example.pdv.application.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repositoryGenP;

    @PostMapping
    public void salvarProduto(@RequestBody Produto products){
        repositoryGenP.save(products);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> buscarProduct(){
        return new ResponseEntity<Object>(repositoryGenP.findAll(), HttpStatus.OK);
    }
}
