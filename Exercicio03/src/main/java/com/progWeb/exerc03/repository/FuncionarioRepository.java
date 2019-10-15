package com.progWeb.exerc03.repository;

import com.progWeb.exerc03.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
