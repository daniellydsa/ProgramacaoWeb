package bsi.progWeb.exerc04.controller;

import bsi.progWeb.exerc04.model.Cama;
import bsi.progWeb.exerc04.model.Hotel;
import bsi.progWeb.exerc04.model.TipoQuartoQtdCama;
import bsi.progWeb.exerc04.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hoteis")
public class HotelController {
    
    @Autowired
    private HotelRepository repo;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Hotel> getAll(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Hotel> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Hotel hotel){
        repo.save(hotel);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void putById(@RequestBody Hotel hotel, @PathVariable("id") long id){
        repo.save(hotel);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") long id){
        repo.deleteById(id);
    }    
    
    @RequestMapping(path = "/{id}/camas", method = RequestMethod.GET)
    public List<Cama> getAllCamas(@PathVariable("id") Long id){
        return repo.findAllCamas(id);
    }
    
    @RequestMapping(path = "/{id}/countTipoCama", method = RequestMethod.GET)
    public List<TipoQuartoQtdCama> getAllTipoCamas(@PathVariable("id") Long id){
        return repo.countQuartosECamas(id);
    }
    
}
