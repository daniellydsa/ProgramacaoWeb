package com.progWeb.exerc03.controller;

import com.progWeb.exerc03.models.Funcionario;
import com.progWeb.exerc03.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository repository;
    
    @RequestMapping(path = "/funcionarios", method = RequestMethod.GET)
    public List<Funcionario> getFuncionarios() {
        return repository.findAll();
    }
    
    @RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.GET)
    public Optional<Funcionario> getFuncionario(@PathVariable Long id) {
        return repository.findById(id);
    }
    
    @RequestMapping(path = "/funcionarios", method = RequestMethod.POST)
    public void addFuncionario(@RequestBody Funcionario f) {
        repository.save(f);
    }
    
    @RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.PUT)
    public void setFuncionario(@PathVariable Long id, @RequestBody Funcionario f) {
        f.setId(id);
        repository.save(f);
    }
    
    @RequestMapping(path = "/funcionarios/{id}", method = RequestMethod.DELETE)
    public void deleteFuncionario(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}
