package com.example.pdv.application.controller;

import com.example.pdv.application.model.Funcionario;
import com.example.pdv.application.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/att/funcionario")
public class AttFuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PutMapping("/{id}")
    public Funcionario atualizaFuncionario(@PathVariable("id") Integer id, @RequestBody Funcionario funcionario){
        return attFuncionario(id, funcionario);
    }

    public Funcionario attFuncionario(Integer id, Funcionario funcionario) {
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

}
