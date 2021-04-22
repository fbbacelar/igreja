package br.com.fabio.igreja.controllers.dto;

import java.util.stream.Collectors;

import br.com.fabio.igreja.models.Membro;

import java.util.ArrayList;
import java.util.List;

public class MembroDetalheDto {

    private final Long id;
    private final String nome;
    private final String sexo;
    private final List<ChamadoDto> chamados;
    private final UnidadeDto unidade;

    public MembroDetalheDto(Membro membro) {
        this.id = membro.getId();
        this.nome = membro.getNome();
        this.sexo = membro.getSexo();
        this.chamados = new ArrayList<>();
        this.chamados.addAll(membro.getChamados().stream().map(ChamadoDto::new).collect(Collectors.toList()));
        this.unidade = new UnidadeDto(membro.getUnidade());
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
    
    public List<ChamadoDto> getChamados() {
        return chamados;
    }

    public UnidadeDto getUnidade() {
        return unidade;
    }

    public static List<MembroDetalheDto> converter(List<Membro> membros) {
        return membros.stream().map(MembroDetalheDto::new).collect(Collectors.toList());
    }
}
