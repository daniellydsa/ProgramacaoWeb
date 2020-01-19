package bsi.progWeb.exerc04.repository;

import bsi.progWeb.exerc04.model.Cama;
import bsi.progWeb.exerc04.model.Hotel;
import bsi.progWeb.exerc04.model.TipoQuartoQtdCama;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
    @Query(value = "Select c from Hotel h join h.quartos q join q.camas c where h.id = :id")
    public List<Cama> findAllCamas(@Param("id") Long id);
    
    public List<TipoQuartoQtdCama> countQuartosECamas(@Param("id") Long id);
}

