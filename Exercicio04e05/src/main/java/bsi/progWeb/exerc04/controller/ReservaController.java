package bsi.progWeb.exerc04.controller;

import bsi.progWeb.exerc04.model.Reserva;
import bsi.progWeb.exerc04.repository.ReservaRepository;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaRepository repo;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Reserva> getAll(){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Reserva> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Reserva reserva){
        repo.save(reserva);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void putById(@RequestBody Reserva reserva, @PathVariable("id") long id){
        repo.save(reserva);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") long id){
        repo.deleteById(id);
    }    
    
    @RequestMapping(path = "/consulta", method = RequestMethod.GET)
    public List<Reserva> getByCliente(@RequestParam("idCliente") Long idCliente, 
            @RequestParam("idFuncionario") Long idFuncionario,
            @RequestParam("idQuarto") Long idQuarto){
        return repo.findAll();
    }
    
    @RequestMapping(path = "/datas", method = RequestMethod.GET)
    public List<Reserva> getDatas(@RequestParam("date1") @DateTimeFormat(pattern = "dd/MM/yyyy") Calendar date1,
            @RequestParam("date2") @DateTimeFormat(pattern = "dd/MM/yyyy") Calendar date2) {
        return repo.findBydataReservaBetween(date1, date2);
    }
    
}
