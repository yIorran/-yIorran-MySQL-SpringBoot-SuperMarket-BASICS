package com.example.pdv.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class LoginFuncionarioEntitie {

    @Id
    private Integer matricula;
    private Integer senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginFuncionarioEntitie that = (LoginFuncionarioEntitie) o;
        return Objects.equals(matricula, that.matricula) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, senha);
    }

    @Override
    public String toString() {
        return "LoginFuncionarioEntitie{" +
                "matricula=" + matricula +
                ", senha=" + senha +
                '}';
    }
}
