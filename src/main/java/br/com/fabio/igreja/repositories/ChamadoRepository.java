package br.com.fabio.igreja.repositories;

import br.com.fabio.igreja.models.Chamado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

    public List<Chamado> findByMembros_Nome(String nome);
    
}
