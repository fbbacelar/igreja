package br.com.fabio.igreja.repositories;

import br.com.fabio.igreja.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

    
}
