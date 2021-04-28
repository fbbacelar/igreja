package br.com.fabio.igreja.repositories;

import br.com.fabio.igreja.models.Papeleta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PapeletaRepository extends JpaRepository<Papeleta, Long>{

    public List<Papeleta> findByMembro_Nome(String nome);
    
}
