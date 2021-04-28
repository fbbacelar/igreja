package br.com.fabio.igreja.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.controllers.form.ChamadoSemMembrosForm;
import br.com.fabio.igreja.controllers.form.PapeletaMembroForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="Membro")
@Table(name="membro")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Membro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @Length(min = 3, max = 80)
    private String nome;
    
    @Length(min = 1, max = 1)
    private String sexo;
    
    @ManyToMany
    //Adicionar joinColumn
    private List<Chamado> chamados;

    @ManyToOne
    private Unidade unidade;

    @OneToMany(mappedBy = "membro")
    private List<Papeleta> papeleta;

    public Membro(Long id, String nome, String sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }

    public Membro(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }
    
    public Membro(String nome, String sexo, List<ChamadoSemMembrosForm> chamadosForm, Unidade unidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.chamados = new ArrayList<>();
        if (chamadosForm != null)
        this.chamados.addAll(chamadosForm.stream().map(Chamado::new).collect(Collectors.toList()));
        this.unidade = unidade;
        ;
    }

    public Membro(PapeletaMembroForm membroForm){
        this.id = membroForm.getId();
        this.nome = membroForm.getNome();
        this.sexo = membroForm.getSexo();
    }

}