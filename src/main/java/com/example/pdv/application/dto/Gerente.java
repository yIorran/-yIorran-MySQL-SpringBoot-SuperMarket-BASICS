package com.example.pdv.application.dto;

import com.example.pdv.application.model.FuncionarioEntitie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Gerente extends FuncionarioEntitie {

    private Integer codAut;

    public Gerente (Integer codAut){
        this.codAut = 321;
    }

}
