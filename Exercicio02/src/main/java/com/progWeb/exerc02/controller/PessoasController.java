package com.progWeb.exerc02.controller;

import com.progWeb.exerc02.model.Pessoa;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exerc02")
public class PessoasController {
    
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    @RequestMapping(path = "/clientes", method = RequestMethod.GET)
    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    
    @RequestMapping(path = "/clientes/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Pessoa getClientes(@PathVariable("nome") String nome) {
        for (Pessoa pes : listaPessoas) {
            if (pes.getNome().equalsIgnoreCase(nome)) {
                return pes;
            }
        }
        return null;
    }
    
    @RequestMapping(path = "/clientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postCliente(@RequestBody Pessoa pes) {
        
        listaPessoas.add(pes);
    }
    
    @RequestMapping(path = "/clientes/{nome}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void putCliente(@PathVariable("nome") String nome, @RequestBody Pessoa pes) {
        for (Pessoa p : listaPessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                listaPessoas.set(listaPessoas.indexOf(p), pes);
            }
        }
    }
    
    @RequestMapping(path = "/clientes/{nome}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCliente(@PathVariable("nome") String nome) {
        for (Pessoa pes : listaPessoas) {
            if (pes.getNome().equalsIgnoreCase(nome)) {
                listaPessoas.remove(pes);
                break;
            }
        }
    }
}