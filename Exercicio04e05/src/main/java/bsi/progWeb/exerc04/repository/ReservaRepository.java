package bsi.progWeb.exerc04.repository;

import bsi.progWeb.exerc04.model.Reserva;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    public List<Reserva> findReservaByCliente(@Param("idC") Long idCliente,
            @Param("idF") Long idFuncionario,
            @Param("idQ") Long idQuarto);

    public List<Reserva> findBydataReservaBetween(Calendar date1, Calendar date2);

}
