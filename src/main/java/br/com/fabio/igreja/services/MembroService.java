package br.com.fabio.igreja.services;

import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.repositories.MembroRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {
 
    @Autowired
    private MembroRepository membroRepository;

    public void save(Membro entity) {
        membroRepository.save(entity);
    }

    public void edit(Membro entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Membro entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Membro findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Membro> findAll() {
        return membroRepository.findAll();
    }
    
    public List<Membro> findByChamados_Nome(String nome) {
        return membroRepository.findByChamados_Nome(nome);
    }

    public List<Membro> findAll(int first, int pageSize, String sortField, boolean ascending, HashMap<String, Object> search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Membro getOne(Long id) {
        return membroRepository.getOne(id);
    }

}
