package com.example.pdv.application.service;

public interface LoginCaixa {

    boolean validaLogin(Integer login, Integer senha);
    boolean validaLoginGerente(Integer login, Integer senha, Integer codAut);

}
