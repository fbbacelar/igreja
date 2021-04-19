package br.com.fabio.igreja.services;

import br.com.fabio.igreja.controllers.dto.MembroDetalheDto;
import br.com.fabio.igreja.controllers.dto.MembroDto;
import br.com.fabio.igreja.controllers.form.MembroForm;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.repositories.MembroRepository;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Transactional
public class MembroService {
 
    @Autowired
    private MembroRepository repository;

    public void save(Membro entity) {
        repository.save(entity);
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
        return repository.findAll();
    }
    
    public List<Membro> findByChamados_Nome(String nome) {
        return repository.findByChamados_Nome(nome);
    }

    public List<Membro> findAll(int first, int pageSize, String sortField, boolean ascending, HashMap<String, Object> search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public MembroDetalheDto getOne(Long id) {
        return new MembroDetalheDto(repository.getOne(id));
    }

    public List<MembroDto> find(String chamadoNome) {
        if (chamadoNome == null) {
            List<Membro> membros = repository.findAll();
            return MembroDto.converter(membros);
        } else {
            List<Membro> membros = repository.findByChamados_Nome(chamadoNome);
            return MembroDto.converter(membros);
        }
    }

    public ResponseEntity<MembroDetalheDto> save(MembroForm membroForm, UriComponentsBuilder uriBuilder) {
        Membro membro = membroForm.converter();
        repository.save(membro);
        URI uri = uriBuilder.path("/membros/{id}").buildAndExpand(membro.getId()).toUri();
        return ResponseEntity.created(uri).body(new MembroDetalheDto(membro));
    }

    public ResponseEntity<MembroDetalheDto> atualizar(Long id, @Valid MembroForm membroForm) {
        Membro membro = repository.getOne(id);
        membro = membroForm.atualizar(membro);
        return ResponseEntity.ok(new MembroDetalheDto(membro));
    }

}
