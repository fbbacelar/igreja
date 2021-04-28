package br.com.fabio.igreja.services;

import br.com.fabio.igreja.Utils.Validacoes;
import br.com.fabio.igreja.controllers.dto.PapeletaDto;
import br.com.fabio.igreja.controllers.form.PapeletaForm;
import br.com.fabio.igreja.exceptions.ServiceException;
import br.com.fabio.igreja.models.Papeleta;
import br.com.fabio.igreja.repositories.PapeletaRepository;
import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Transactional
public class PapeletaService {
 
    @Autowired
    private PapeletaRepository repository;

    public void save(Papeleta papeleta) {
        repository.save(papeleta);
    }

    public void edit(Papeleta entity) {
    }

    public void remove(Papeleta entity) {
    }

    public Papeleta findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Papeleta> findAll() {
        return repository.findAll();
    }
    
    public List<Papeleta> findByMembros_Nome(String nome) {
        return repository.findByMembro_Nome(nome);
    }

    public PapeletaDto getOne(Long id) throws ServiceException {
        Validacoes.verificaId(id);
        return new PapeletaDto(repository.getOne(id));
    }
    
    public List<PapeletaDto> find(String membroNome) {
        if (membroNome == null) {
            List<Papeleta> papeletas = repository.findAll();
            return PapeletaDto.converter(papeletas);
        } else {
            List<Papeleta> papeletas = repository.findByMembro_Nome(membroNome);
            return PapeletaDto.converter(papeletas);
        }
    }

    public ResponseEntity<PapeletaDto> save(PapeletaForm papeletaForm, UriComponentsBuilder uriBuilder) {
        Papeleta papeleta = papeletaForm.converter();
        repository.save(papeleta);
        URI uri = uriBuilder.path("/papeletas/{id}").buildAndExpand(papeleta.getId()).toUri();
        return ResponseEntity.created(uri).body(new PapeletaDto(papeleta));
    }

    // public ResponseEntity<PapeletaDto> atualizar(Long id, PapeletaForm papeletaForm) {
    //     Papeleta papeleta = repository.getOne(id);
    //     papeleta = papeletaForm.atualizar(papeleta);
    //     return ResponseEntity.ok(new PapeletaDto(papeleta));
    // }

    public ResponseEntity<?> deleteById(Long id) throws ServiceException {
        Validacoes.verificaId(id);
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
