package br.com.fabio.igreja.controllers;

import br.com.fabio.igreja.controllers.dto.MembroDetalheDto;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import br.com.fabio.igreja.controllers.dto.MembroDto;
import br.com.fabio.igreja.controllers.form.MembroForm;
import br.com.fabio.igreja.services.MembroService;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/membros")
public class MembroController {
    
    @Inject
    MembroService service;

    @GetMapping
    public List<MembroDto> listar(String chamadoNome) {
        return service.find(chamadoNome);
    }

    @PostMapping
    public ResponseEntity<MembroDetalheDto> salvar(@RequestBody @Valid MembroForm membroForm, UriComponentsBuilder uriBuilder) {
        return service.save(membroForm, uriBuilder);
    }
    
    @GetMapping("/{id}")
    public MembroDetalheDto buscar(@PathVariable Long id){
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembroDetalheDto> atualizar(@RequestBody @Valid MembroForm membroForm, @PathVariable Long id) {
        return service.atualizar(id, membroForm);
    }
}
