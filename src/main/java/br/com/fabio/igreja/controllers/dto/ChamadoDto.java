package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.models.Chamado;
import java.util.stream.Collectors;

import java.util.List;

public class ChamadoDto {

    private final Long id;
    private final String nome;

    public ChamadoDto(Chamado chamado) {
        this.id = chamado.getId();
        this.nome = chamado.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<ChamadoDto> converter(List<Chamado> chamados) {
        return chamados.stream().map(ChamadoDto::new).collect(Collectors.toList());
    }

}
