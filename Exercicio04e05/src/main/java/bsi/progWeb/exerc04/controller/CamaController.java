package bsi.progWeb.exerc04.controller;

import bsi.progWeb.exerc04.model.Cama;
import bsi.progWeb.exerc04.repository.CamaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/camas")
public class CamaController {
    
    @Autowired
    private CamaRepository repo;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Cama> getAll(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Cama> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Cama cama){
        repo.save(cama);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void putById(@RequestBody Cama cama, @PathVariable("id") long id){
        repo.save(cama);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") long id){
        repo.deleteById(id);
    }    
    
}
