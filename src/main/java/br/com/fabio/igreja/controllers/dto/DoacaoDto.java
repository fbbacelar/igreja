package br.com.fabio.igreja.controllers.dto;

import br.com.fabio.igreja.controllers.enums.TipoDoacao;
import br.com.fabio.igreja.models.Doacao;
import lombok.Getter;

@Getter
public class DoacaoDto {

  private final Long id;
  
  private final TipoDoacao tipoDoacao;

  private final Double valor;


  public DoacaoDto (Doacao doacao){
    this.id = doacao.getId();
    this.tipoDoacao = doacao.getTipoDoacao();
    this.valor = doacao.getValor();
  }

}
