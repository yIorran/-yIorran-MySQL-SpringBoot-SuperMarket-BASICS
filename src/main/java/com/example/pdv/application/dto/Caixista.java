package com.example.pdv.application.dto;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.service.LoginCaixa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Caixista extends Funcionario implements LoginCaixa {

    @Override
    public boolean validaLogin(Integer login, Integer senha) {
        return false;
    }

    @Override
    public boolean validaLoginGerente(Integer login, Integer senha, Integer codAut) {
        return false;
    }
}
