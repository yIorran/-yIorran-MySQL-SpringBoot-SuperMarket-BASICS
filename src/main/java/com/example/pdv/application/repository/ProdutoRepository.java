package com.example.pdv.application.repository;

import com.example.pdv.application.model.ProdutoEntitie;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<ProdutoEntitie, Number> {
}
