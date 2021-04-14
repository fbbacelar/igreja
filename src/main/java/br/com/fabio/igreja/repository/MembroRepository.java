package br.com.fabio.igreja.repository;

import br.com.fabio.igreja.modelo.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long>{
    
}
