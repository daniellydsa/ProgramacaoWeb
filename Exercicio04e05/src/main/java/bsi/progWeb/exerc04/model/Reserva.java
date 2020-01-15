package bsi.progWeb.exerc04.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Reserva.findReservaByCliente",
        query = "SELECT r FROM Reserva r JOIN r.cliente c JOIN r.funcionario f JOIN r.quartos q WHERE c.id = :idC AND f.id = :idF AND q.id = :idQ")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar   dataReserva;
    
    @ManyToOne
    private Funcionario funcionario;
    
    @ManyToOne
    private Cliente cliente;
    
   
    
    @ManyToMany
    private List<Quarto> quartos;
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Calendar getDataReserva() {
        return  dataReserva;
    }

    public void setDataReserva(Calendar  dataReserva) {
        this. dataReserva =  dataReserva;
    }

    public List<Quarto> getQuarto() {
        return quartos;
    }

    public void setQuarto(List<Quarto> quarto) {
        this.quartos = quarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
