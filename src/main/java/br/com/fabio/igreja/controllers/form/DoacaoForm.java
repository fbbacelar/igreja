package br.com.fabio.igreja.controllers.form;

import br.com.fabio.igreja.controllers.enums.TipoDoacao;
import br.com.fabio.igreja.models.Doacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoacaoForm {


  private TipoDoacao tipoDoacao;

  private Double valor;

  public Doacao converter(DoacaoForm doacaoForm){
    return new Doacao(doacaoForm);
  }
}
