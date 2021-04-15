package br.com.fabio.igreja.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.igreja.controllers.dto.MembroDto;
import br.com.fabio.igreja.controllers.form.MembroForm;
import br.com.fabio.igreja.exceptions.ServiceException;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.services.MembroService;
import java.net.URI;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<MembroDto> listar(String nome) throws ServiceException {
        if (nome == null) {
            List<Membro> membros = service.findAll();
            return MembroDto.converter(membros);
        } else {
            List<Membro> membros = service.findByNome(nome);
            return MembroDto.converter(membros);
        }
    }

    @PostMapping
    public ResponseEntity<MembroDto> salvar(@RequestBody @Valid MembroForm form, UriComponentsBuilder uriBuilder) {
        Membro membro = form.converter();
        service.save(membro);
        
        URI uri = uriBuilder.path("/membros/{id}").buildAndExpand(membro.getId()).toUri();
        return ResponseEntity.created(uri).body(new MembroDto(membro));
    }

}
