package com.example.pdv.application.service;

import com.example.pdv.application.model.FuncionarioEntitie;

import org.springframework.stereotype.Component;

@Component
public class LoginCaixaImpl extends FuncionarioEntitie implements LoginCaixa {


    @Override
    public boolean validaLogin(Integer login, Integer senha) {
        if(login != super.getMatricula() || senha != super.getSenha()){
            System.out.println("Login reprovado");
        }
        else if (login == super.getMatricula() && senha == super.getSenha()){
            System.out.println("Login aprovado");
        }
        return true;
    }

    @Override
    public boolean validaLoginGerente(Integer login, Integer senha, Integer codAut) {
        codAut = 321;
        if(login != super.getMatricula() || senha != super.getSenha()){
            System.out.println("Login reprovado");
        }
        else if (login == super.getMatricula() && senha == super.getSenha() && codAut == codAut){
            System.out.println("Login aprovado");
        }
        return true;

    }
}
