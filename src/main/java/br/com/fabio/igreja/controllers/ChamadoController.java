package br.com.fabio.igreja.controllers;

import br.com.fabio.igreja.controllers.dto.ChamadoDetalheDto;
import br.com.fabio.igreja.controllers.dto.ChamadoDto;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import br.com.fabio.igreja.controllers.form.ChamadoForm;
import br.com.fabio.igreja.services.ChamadoService;
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
        return service.find(membroNome);
    }

    @PostMapping
    public ResponseEntity<ChamadoDetalheDto> salvar(@RequestBody @Valid ChamadoForm chamadoForm, UriComponentsBuilder uriBuilder) {
        return service.save(chamadoForm, uriBuilder);
    }
    
    @GetMapping("/{id}")
    public ChamadoDetalheDto buscar(@PathVariable Long id){
        return service.getOne(id);
    }

}
