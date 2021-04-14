package br.com.fabio.igreja.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.igreja.controller.dto.MembroDto;
import br.com.fabio.igreja.modelo.Membro;
import br.com.fabio.igreja.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MembroController {
    
    @Autowired
    private MembroRepository membroRepository;

    @RequestMapping("/membros")
    public List<MembroDto> lista() {
        List<Membro> membros = membroRepository.findAll();
        return MembroDto.converter(membros);
    }
    
}