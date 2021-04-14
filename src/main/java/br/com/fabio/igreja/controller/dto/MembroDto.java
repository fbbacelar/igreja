package br.com.fabio.igreja.controller.dto;

import java.util.stream.Collectors;

import br.com.fabio.igreja.modelo.Membro;
import java.util.List;

public class MembroDto {

    private Long id;
    private String nome;

    public MembroDto(Membro membro) {
        this.id = membro.getId();
        this.nome = membro.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<MembroDto> converter(List<Membro> topicos) {
        return topicos.stream().map(MembroDto::new).collect(Collectors.toList());
    }
    
}
