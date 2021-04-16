package br.com.fabio.igreja.controllers;

import br.com.fabio.igreja.controllers.dto.ChamadoDetalheDto;
import br.com.fabio.igreja.controllers.dto.ChamadoDto;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.igreja.controllers.form.ChamadoForm;
import br.com.fabio.igreja.models.Chamado;
import br.com.fabio.igreja.services.ChamadoService;
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
@RequestMapping("/chamados")
public class ChamadoController {
    
    @Inject
    ChamadoService service;

    @GetMapping
    public List<ChamadoDto> listar(String membroNome) {
        if (membroNome == null) {
            List<Chamado> chamados = service.findAll();
            return ChamadoDto.converter(chamados);
        } else {
            List<Chamado> chamados = service.findByMembros_Nome(membroNome);
            return ChamadoDto.converter(chamados);
        }
    }

    @PostMapping
    public ResponseEntity<ChamadoDetalheDto> salvar(@RequestBody @Valid ChamadoForm form, UriComponentsBuilder uriBuilder) {
        Chamado chamado = form.converter();
        service.save(chamado);
        
        URI uri = uriBuilder.path("/chamados/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ChamadoDetalheDto(chamado));
    }
    
    @GetMapping("/{id}")
    public ChamadoDetalheDto buscar(@PathVariable Long id){
        Chamado chamado = service.getOne(id);
        return new ChamadoDetalheDto(chamado);
    }

}
