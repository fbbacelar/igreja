package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.models.Papeleta;
import lombok.Getter;

import java.util.stream.Collectors;

import java.util.List;

@Getter
public class PapeletaDto {

    private final Long id;
    private final List<DoacaoDto> doacoes;
    private final MembroDto membro;

    public PapeletaDto(Papeleta papeleta) {
        this.id = papeleta.getId();
        this.doacoes = papeleta.getDoacoes().stream().map(DoacaoDto::new).collect(Collectors.toList());
        this.membro = new MembroDto(papeleta.getMembro());
    }

    public static List<PapeletaDto> converter(List<Papeleta> papeletas) {
        return papeletas.stream().map(PapeletaDto::new).collect(Collectors.toList());
    }

}
