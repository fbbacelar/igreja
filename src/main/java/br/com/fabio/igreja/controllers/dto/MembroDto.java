package br.com.fabio.igreja.controllers.dto;

import java.util.stream.Collectors;

import br.com.fabio.igreja.models.Membro;
// import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MembroDto {

    private final Long id;
    
    private final String nome;
    
    private final String sexo;

    public MembroDto(Membro membro) {
        this.id = membro.getId();
        this.nome = membro.getNome();
        this.sexo = membro.getSexo();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public static List<MembroDto> converter(List<Membro> membros) {
        return membros.stream().map(MembroDto::new).collect(Collectors.toList());
    }
}