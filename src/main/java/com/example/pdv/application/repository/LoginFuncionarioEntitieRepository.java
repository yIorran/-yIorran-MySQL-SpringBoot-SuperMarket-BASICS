package com.example.pdv.application.repository;

import com.example.pdv.application.model.LoginFuncionarioEntitie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginFuncionarioEntitieRepository extends JpaRepository<LoginFuncionarioEntitie, Object> {

    Optional<LoginFuncionarioEntitie> findByMatricula(Integer matricula);
    Optional<LoginFuncionarioEntitie> findBySenha(Integer senha);
}

