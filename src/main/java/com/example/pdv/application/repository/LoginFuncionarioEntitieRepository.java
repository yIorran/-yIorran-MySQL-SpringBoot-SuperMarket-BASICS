package com.example.pdv.application.repository;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.model.LoginFuncionarioEntitie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginFuncionarioEntitieRepository extends CrudRepository<LoginFuncionarioEntitie, Object> {

    Optional<LoginFuncionarioEntitie> findByMatricula(Integer matricula);
    Optional<LoginFuncionarioEntitie> findBySenha(Integer senha);
}

