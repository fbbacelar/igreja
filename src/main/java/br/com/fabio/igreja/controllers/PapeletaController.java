package br.com.fabio.igreja.controllers;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fabio.igreja.controllers.dto.PapeletaDto;
import br.com.fabio.igreja.controllers.form.PapeletaForm;
import br.com.fabio.igreja.exceptions.ServiceException;
import br.com.fabio.igreja.services.PapeletaService;

@RestController
@RequestMapping("/papeletas")
public class PapeletaController {
    
    @Inject
    PapeletaService service;

    @GetMapping
    public List<PapeletaDto> listar(String membroNome) {
        return service.find(membroNome);
    }

    @PostMapping
    public ResponseEntity<PapeletaDto> salvar(@RequestBody @Valid PapeletaForm papeletaForm, UriComponentsBuilder uriBuilder) {
        return service.save(papeletaForm, uriBuilder);
    }
    
    @GetMapping("/{id}")
    public PapeletaDto buscar(@PathVariable Long id) throws ServiceException{
        return service.getOne(id);
    }

    //Não é permitido alterar papeleta
    // @PutMapping("/{id}")
    // public ResponseEntity<PapeletaDto> atualizar(@RequestBody @Valid PapeletaForm papeletaForm, @PathVariable Long id) {
    //     return service.atualizar(id, papeletaForm);
    // }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) throws ServiceException {
        return service.deleteById(id);
    }

}
