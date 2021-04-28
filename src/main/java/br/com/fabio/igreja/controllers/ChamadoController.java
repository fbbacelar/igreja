package br.com.fabio.igreja.controllers;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
import br.com.fabio.igreja.controllers.dto.ChamadoDetalheDto;
import br.com.fabio.igreja.controllers.dto.ChamadoDto;
import br.com.fabio.igreja.controllers.form.ChamadoForm;
import br.com.fabio.igreja.exceptions.ServiceException;
import br.com.fabio.igreja.services.ChamadoService;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    
    @Inject
    ChamadoService service;

    @GetMapping
    public ResponseEntity<List<ChamadoDto>> listar(String membroNome) {
        return service.find(membroNome);
    }

    @PostMapping
    public ResponseEntity<ChamadoDetalheDto> salvar(@RequestBody @Valid ChamadoForm chamadoForm, UriComponentsBuilder uriBuilder) {
        return service.save(chamadoForm, uriBuilder);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDetalheDto> buscar(@PathVariable @Min(value = 1) @NotNull Long id) throws ServiceException{
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDetalheDto> atualizar(@RequestBody @Valid ChamadoForm chamadoForm, @PathVariable Long id) throws ServiceException {
        return service.atualizar(id, chamadoForm);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws ServiceException {
        return service.deleteById(id);
    }

}
