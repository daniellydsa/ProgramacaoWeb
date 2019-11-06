package bsi.progWeb.exerc04.controller;

import bsi.progWeb.exerc04.model.Cliente;
import bsi.progWeb.exerc04.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repo;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> getAll(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Cliente> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Cliente cliente){
        repo.save(cliente);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void putById(@RequestBody Cliente cliente, @PathVariable("id") long id){
        repo.save(cliente);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") long id){
        repo.deleteById(id);
    } 
    
    @RequestMapping(path = "/{id}/countReservas", method = RequestMethod.GET)
    public int getQuantReservas(@PathVariable("id") Long id){
        return repo.getQuantReservas(id);
    }
    
}
