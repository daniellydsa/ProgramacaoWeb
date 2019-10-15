package com.progWeb.exerc03.controller;

import com.progWeb.exerc03.models.Endereco;
import com.progWeb.exerc03.repository.EnderecoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoControler {
    
    @Autowired
    private EnderecoRepository repository;
    
    @RequestMapping(path = "/enderecos", method = RequestMethod.GET)
    public List<Endereco> getEnderecos() {
        return repository.findAll();
    }
    
    @RequestMapping(path = "/enderecos/{id}", method = RequestMethod.GET)
    public Optional<Endereco> getEndereco(@PathVariable Long id) {
        return repository.findById(id);
    }
    
    @RequestMapping(path = "/enderecos", method = RequestMethod.POST)
    public void addEndereco(@RequestBody Endereco end) {
        repository.save(end);
    }
    
    @RequestMapping(path = "/enderecos/{id}", method = RequestMethod.PUT)
    public void setEndereco(@PathVariable Long id, @RequestBody Endereco end) {
        end.setId(id);
        repository.save(end);
    }
    
    @RequestMapping(path = "/enderecos/{id}", method = RequestMethod.DELETE)
    public void deleteEndereco(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}
