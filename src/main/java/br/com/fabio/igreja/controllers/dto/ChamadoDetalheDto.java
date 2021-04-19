package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.models.Chamado;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;

public class ChamadoDetalheDto {

    private final Long id;
    
    private final String nome;
    
    private final List<MembroDto> membros;

    public ChamadoDetalheDto(Chamado chamado) {
        this.id = chamado.getId();
        this.nome = chamado.getNome();
        this.membros = new ArrayList<>();
        this.membros.addAll(chamado.getMembros().stream().map(MembroDto::new).collect(Collectors.toList()));
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

    public static List<ChamadoDto> converter(List<Chamado> chamados) {
        return chamados.stream().map(ChamadoDto::new).collect(Collectors.toList());
    }

}
