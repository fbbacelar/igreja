package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.models.Chamado;
import java.util.stream.Collectors;

import br.com.fabio.igreja.models.Membro;
import java.util.List;

public class MembroDto {

    private Long id;
    private String nome;
    private String sexo;
//    private List<ChamadoDto> chamados;

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

//    public List<ChamadoDto> getChamados() {
//        return chamados;
//    }

    public String getSexo() {
        return sexo;
    }

    public static List<MembroDto> converter(List<Membro> membros) {
        return membros.stream().map(MembroDto::new).collect(Collectors.toList());
    }
}
