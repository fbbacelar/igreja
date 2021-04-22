package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.models.Unidade;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;

public class UnidadeDetalheDto {

    private final Long id;
    
    private final String nome;
    
    private final List<MembroDto> membros;

    public UnidadeDetalheDto(Unidade unidade) {
        this.id = unidade.getId();
        this.nome = unidade.getNome();
        this.membros = new ArrayList<>();
        this.membros.addAll(unidade.getMembros().stream().map(MembroDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public List<MembroDto> getMembros() {
        return membros;
    }

    public static List<UnidadeDto> converter(List<Unidade> unidades) {
        return unidades.stream().map(UnidadeDto::new).collect(Collectors.toList());
    }

}
