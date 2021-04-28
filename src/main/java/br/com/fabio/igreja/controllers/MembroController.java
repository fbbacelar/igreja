package br.com.fabio.igreja.controllers;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fabio.igreja.controllers.dto.MembroDetalheDto;
import br.com.fabio.igreja.controllers.dto.MembroDto;
import br.com.fabio.igreja.controllers.form.MembroForm;
import br.com.fabio.igreja.exceptions.ServiceException;
import br.com.fabio.igreja.services.MembroService;

@RestController
@RequestMapping("/membros")
public class MembroController {
    
    @Inject
    MembroService service;

    @GetMapping
    public ResponseEntity<List<MembroDto>> listar(String chamadoNome, String unidadeNome) {
        return service.listar(chamadoNome, unidadeNome);
    }

    @PostMapping
    public ResponseEntity<MembroDetalheDto> salvar(@RequestBody @Valid MembroForm membroForm, UriComponentsBuilder uriBuilder) {
        return service.salvar(membroForm, uriBuilder);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MembroDetalheDto> buscar(@PathVariable Long id) throws ServiceException{
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembroDetalheDto> atualizar(@RequestBody @Valid MembroForm membroForm, @PathVariable Long id) throws ServiceException {
        return service.atualizar(id, membroForm);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws ServiceException {
        return service.remover(id);
    }
}
