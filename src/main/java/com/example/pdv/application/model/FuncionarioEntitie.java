package com.example.pdv.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FuncionarioEntitie {

    @Id
    private Integer matricula;

    private String nome;
    private Integer senha;


    public FuncionarioEntitie(String nome, Integer matricula, Integer senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

    public FuncionarioEntitie(Integer matricula, Integer senha) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioEntitie that = (FuncionarioEntitie) o;
        return Objects.equals(nome, that.nome) && Objects.equals(matricula, that.matricula) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula, senha);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", senha=" + senha +
                '}';
    }
}
