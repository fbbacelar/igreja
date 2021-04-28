package br.com.fabio.igreja.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import br.com.fabio.igreja.controllers.enums.TipoDoacao;
import br.com.fabio.igreja.controllers.form.DoacaoForm;
import br.com.fabio.igreja.controllers.form.PapeletaForm;


@Entity(name = "Doacao")
@Table(name = "doacao")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Doacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @NotNull
  @ManyToOne(cascade = CascadeType.ALL)
  private Papeleta papeleta;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoDoacao tipoDoacao;

  @NotNull
  private Double valor;

  public Doacao(PapeletaForm papeleta, TipoDoacao tipoDoacao, Double valor){
    this.papeleta = new Papeleta(papeleta);
  }

  public Doacao(DoacaoForm doacaoForm){
    this.tipoDoacao = doacaoForm.getTipoDoacao();
    this.valor = doacaoForm.getValor();
  }


}