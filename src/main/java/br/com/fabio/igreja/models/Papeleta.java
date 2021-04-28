package br.com.fabio.igreja.models;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import br.com.fabio.igreja.controllers.form.PapeletaForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="Papeleta")
@Table(name="papeleta")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Papeleta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @NotNull
    //notEmpty
    @OneToMany(mappedBy = "papeleta", cascade = CascadeType.ALL)
    private List<Doacao> doacoes;

    @ManyToOne
    private Membro membro;

    public Papeleta(PapeletaForm papeletaForm){
        this.doacoes = papeletaForm.getDoacoes().stream().map(Doacao::new).collect(Collectors.toList());
        for (Doacao doacao : this.doacoes) {
            doacao.setPapeleta(this);
        }
        this.membro = new Membro(papeletaForm.getMembro());
    }

}
