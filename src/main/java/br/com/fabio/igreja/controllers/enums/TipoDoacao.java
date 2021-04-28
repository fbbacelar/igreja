package br.com.fabio.igreja.controllers.enums;

import lombok.Getter;

@Getter
public enum TipoDoacao {

  DIZIMO("Dízimo"),
  JEJUM("Oferta de jejum"),
  AUXILIO("Auxílio humanitário");

  private final String tipoDoacao;

  TipoDoacao(String tipoDoacao){
    this.tipoDoacao = tipoDoacao;
  }

}
