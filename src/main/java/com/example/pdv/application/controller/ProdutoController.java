package com.example.pdv.application.controller;

import com.example.pdv.application.model.ProdutoEntitie;
import com.example.pdv.application.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repositoryGenP;

    @PostMapping
    public void salvarProduto(@RequestBody ProdutoEntitie products){
        repositoryGenP.save(products);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<Object> buscarProduct(){
        return new ResponseEntity<Object>(repositoryGenP.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarProdutos(Integer id){
        repositoryGenP.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProdutoEntitie atualizaProduto(@PathVariable("id") Integer id, @RequestBody ProdutoEntitie produtoEntitie){
        return attProduto(id, produtoEntitie);
    }

    public ProdutoEntitie attProduto(Integer id, ProdutoEntitie produtoEntitie) {
        produtoEntitie.setId(id);
        return repositoryGenP.save(produtoEntitie);
    }
}
