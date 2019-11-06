package bsi.progWeb.exerc04.controller;

import bsi.progWeb.exerc04.model.Funcionario;
import bsi.progWeb.exerc04.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository repo;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Funcionario> getAll(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Funcionario> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Funcionario funcionario){
        repo.save(funcionario);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void putById(@RequestBody Funcionario funcionario, @PathVariable("id") long id){
        repo.save(funcionario);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") long id){
        repo.deleteById(id);
    }    
    
    @RequestMapping(path = "/setor/{setor}", method = RequestMethod.GET)
    public List<Funcionario> getBySetor(@PathVariable("setor") String setor){
        return repo.findBySetor(setor);
    }
    
}
