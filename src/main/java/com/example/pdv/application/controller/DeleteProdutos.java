package com.example.pdv.application.controller;

import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deleteProd")
public class DeleteProdutos {

    @Autowired
    ProdutoRepository repositoryGen;

    @DeleteMapping(value = "/{id}")
    public void deletarProdutos(@PathVariable("id") Integer id){
        repositoryGen.deleteById(id);
    }

}
