package br.com.fabio.igreja.services;

import br.com.fabio.igreja.controllers.dto.ChamadoDetalheDto;
import br.com.fabio.igreja.controllers.dto.ChamadoDto;
import br.com.fabio.igreja.controllers.form.ChamadoForm;
import br.com.fabio.igreja.models.Chamado;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.repositories.ChamadoRepository;
import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Transactional
public class ChamadoService {
 
    @Autowired
    private ChamadoRepository repository;

    public void save(Chamado chamado) {
        repository.save(chamado);
    }

    public void edit(Chamado entity) {
    }

    public void remove(Chamado entity) {
    }

    public Membro findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }
    
    public List<Chamado> findByMembros_Nome(String nome) {
        return repository.findByMembros_Nome(nome);
    }

    public ChamadoDetalheDto getOne(Long id) {
        return new ChamadoDetalheDto(repository.getOne(id));
    }
    
    public List<ChamadoDto> find(String membroNome) {
        if (membroNome == null) {
            List<Chamado> chamados = repository.findAll();
            return ChamadoDto.converter(chamados);
        } else {
            List<Chamado> chamados = repository.findByMembros_Nome(membroNome);
            return ChamadoDto.converter(chamados);
        }
    }

    public ResponseEntity<ChamadoDetalheDto> save(ChamadoForm chamadoForm, UriComponentsBuilder uriBuilder) {
        Chamado chamado = chamadoForm.converter();
        repository.save(chamado);
        URI uri = uriBuilder.path("/chamados/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ChamadoDetalheDto(chamado));
    }

    public ResponseEntity<ChamadoDetalheDto> atualizar(Long id, ChamadoForm chamadoForm) {
        Chamado chamado = repository.getOne(id);
        chamado = chamadoForm.atualizar(chamado);
        return ResponseEntity.ok(new ChamadoDetalheDto(chamado));
    }

    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
