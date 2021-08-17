package com.example.pdv.application.model;

import com.example.pdv.application.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String nome;
    private Integer matricula;
    private Integer senha;


    public Funcionario(String nome, Integer matricula, Integer senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

}
