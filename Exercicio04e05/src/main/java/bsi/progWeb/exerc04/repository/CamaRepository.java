package bsi.progWeb.exerc04.repository;

import bsi.progWeb.exerc04.model.Cama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamaRepository extends JpaRepository<Cama, Long>{
    
}

