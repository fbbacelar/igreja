package br.com.fabio.igreja.services;

import br.com.fabio.igreja.models.Chamado;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.repositories.ChamadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {
 
    @Autowired
    private ChamadoRepository repository;

    public void save(Chamado chamado) {
        repository.save(chamado);
    }

    public void edit(Chamado entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Chamado entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Membro findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }
    
    public List<Chamado> findByMembros_Nome(String nome) {
        return repository.findByMembros_Nome(nome);
    }

    public Chamado getOne(Long id) {
        return repository.getOne(id);
    }

}
