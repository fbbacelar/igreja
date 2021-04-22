package br.com.fabio.igreja.repositories;

import br.com.fabio.igreja.models.Unidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<Unidade, Long>{

    public List<Unidade> findByMembros_Nome(String nome);
    
}
