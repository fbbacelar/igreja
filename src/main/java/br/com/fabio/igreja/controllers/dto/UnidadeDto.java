package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.models.Unidade;
import java.util.stream.Collectors;
import java.util.List;

public class UnidadeDto {

    private final Long id;
    private final String nome;

    public UnidadeDto(Unidade unidade) {
        this.id = unidade.getId();
        this.nome = unidade.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<UnidadeDto> converter(List<Unidade> unidades) {
        return unidades.stream().map(UnidadeDto::new).collect(Collectors.toList());
    }

}
