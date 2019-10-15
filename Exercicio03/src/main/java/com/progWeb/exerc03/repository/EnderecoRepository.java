package com.progWeb.exerc03.repository;

import com.progWeb.exerc03.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
