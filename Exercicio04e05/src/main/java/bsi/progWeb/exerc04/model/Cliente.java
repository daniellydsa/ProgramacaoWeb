package bsi.progWeb.exerc04.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.catalina.Manager;

@Entity
@NamedQuery(name = "Cliente.getQuantReservas", query = "SELECT COUNT(r) from Cliente c join c.reservas r where c.id = :id")
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
   
    private Long quantidadeOcupacoes;

    public Long getQuantidadeOcupacoes() {
        return quantidadeOcupacoes;
    }

    public void setQuantidadeOcupacoes(Long quantidadeOcupacoes) {
        this.quantidadeOcupacoes = quantidadeOcupacoes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
