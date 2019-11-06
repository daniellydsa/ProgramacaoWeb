package bsi.progWeb.exerc04.repository;

import bsi.progWeb.exerc04.model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
    public List<Funcionario> findBySetor(String setor);
}

