package br.com.fabio.igreja.controllers;

import br.com.fabio.igreja.controllers.dto.MembroDetalheDto;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.igreja.controllers.dto.MembroDto;
import br.com.fabio.igreja.controllers.form.MembroForm;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.services.MembroService;
import java.net.URI;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        if (chamadoNome == null) {
            List<Membro> membros = service.findAll();
            return MembroDto.converter(membros);
        } else {
            List<Membro> membros = service.findByChamados_Nome(chamadoNome);
            return MembroDto.converter(membros);
        }
    }

    @PostMapping
    public ResponseEntity<MembroDetalheDto> salvar(@RequestBody @Valid MembroForm form, UriComponentsBuilder uriBuilder) {
        Membro membro = form.converter();
        service.save(membro);
        
        URI uri = uriBuilder.path("/membros/{id}").buildAndExpand(membro.getId()).toUri();
        return ResponseEntity.created(uri).body(new MembroDetalheDto(membro));
    }
    
    @GetMapping("/{id}")
    public MembroDetalheDto buscar(@PathVariable Long id){
        Membro membro = service.getOne(id);
        return new MembroDetalheDto(membro);
    }

}
