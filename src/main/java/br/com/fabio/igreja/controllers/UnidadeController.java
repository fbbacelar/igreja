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
import br.com.fabio.igreja.controllers.dto.UnidadeDetalheDto;
import br.com.fabio.igreja.controllers.dto.UnidadeDto;
import br.com.fabio.igreja.controllers.form.UnidadeForm;
import br.com.fabio.igreja.exceptions.ServiceException;
import br.com.fabio.igreja.services.UnidadeService;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {
    
    @Inject
    UnidadeService service;

    @GetMapping
    public ResponseEntity<List<UnidadeDto>> listar(String membroNome) {
        return service.find(membroNome);
    }

    @PostMapping
    public ResponseEntity<UnidadeDetalheDto> salvar(@RequestBody @Valid UnidadeForm unidadeForm, UriComponentsBuilder uriBuilder) {
        return service.save(unidadeForm, uriBuilder);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeDetalheDto> buscar(@PathVariable Long id) throws ServiceException{
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeDetalheDto> atualizar(@RequestBody @Valid UnidadeForm unidadeForm, @PathVariable Long id) throws ServiceException {
        return service.atualizar(id, unidadeForm);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws ServiceException {
        return service.deleteById(id);
    }
}
