package com.example.pdv.application.repository;

import com.example.pdv.application.model.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Number> {
}
