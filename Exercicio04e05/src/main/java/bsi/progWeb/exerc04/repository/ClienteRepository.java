package bsi.progWeb.exerc04.repository;

import bsi.progWeb.exerc04.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
   
    public int getQuantReservas(@Param("id") Long id);

}

