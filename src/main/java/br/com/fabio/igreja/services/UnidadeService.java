package br.com.fabio.igreja.services;

import br.com.fabio.igreja.controllers.dto.UnidadeDetalheDto;
import br.com.fabio.igreja.controllers.dto.UnidadeDto;
import br.com.fabio.igreja.controllers.form.UnidadeForm;
import br.com.fabio.igreja.models.Unidade;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.repositories.UnidadeRepository;
import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Transactional
public class UnidadeService {
 
    @Autowired
    private UnidadeRepository repository;

    public void save(Unidade chamado) {
        repository.save(chamado);
    }

    public void edit(Unidade entity) {
    }

    public void remove(Unidade entity) {
    }

    public Membro findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Unidade> findAll() {
        return repository.findAll();
    }
    
    public List<Unidade> findByMembros_Nome(String nome) {
        return repository.findByMembros_Nome(nome);
    }

    public UnidadeDetalheDto getOne(Long id) {
        return new UnidadeDetalheDto(repository.getOne(id));
    }
    
    public List<UnidadeDto> find(String membroNome) {
        if (membroNome == null) {
            List<Unidade> unidades = repository.findAll();
            return UnidadeDto.converter(unidades);
        } else {
            List<Unidade> unidades = repository.findByMembros_Nome(membroNome);
            return UnidadeDto.converter(unidades);
        }
    }

    public ResponseEntity<UnidadeDetalheDto> save(UnidadeForm chamadoForm, UriComponentsBuilder uriBuilder) {
        Unidade chamado = chamadoForm.converter();
        repository.save(chamado);
        URI uri = uriBuilder.path("/chamados/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new UnidadeDetalheDto(chamado));
    }

    public ResponseEntity<UnidadeDetalheDto> atualizar(Long id, UnidadeForm chamadoForm) {
        Unidade chamado = repository.getOne(id);
        chamado = chamadoForm.atualizar(chamado);
        return ResponseEntity.ok(new UnidadeDetalheDto(chamado));
    }

    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
