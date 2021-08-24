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
import java.util.Objects;

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

    public Funcionario(Integer matricula, Integer senha) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(Id, that.Id) && Objects.equals(nome, that.nome) && Objects.equals(matricula, that.matricula) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, matricula, senha);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", senha=" + senha +
                '}';
    }
}
