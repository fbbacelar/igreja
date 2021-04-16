package br.com.fabio.igreja.repositories;

import br.com.fabio.igreja.models.Membro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long>{

    public List<Membro> findByChamados_Nome(String nome);

}
