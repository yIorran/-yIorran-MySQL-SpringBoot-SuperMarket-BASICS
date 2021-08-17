package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.model.Produto;
import com.example.pdv.application.repository.FuncionarioRepository;
import com.example.pdv.application.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/att/produto")
public class AttProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PutMapping("/{id}")
    public Produto atualizaProduto(@PathVariable("id") Integer id, @RequestBody Produto produto){
        return attProduto(id, produto);
    }

    public Produto attProduto(Integer id, Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

}
