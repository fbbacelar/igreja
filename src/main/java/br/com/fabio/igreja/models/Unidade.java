package br.com.fabio.igreja.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.controllers.form.UnidadeSemMembrosForm;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Unidade")
@Table(name="unidade")
@Data
@NoArgsConstructor
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Length(min = 3, max = 80)
    private String nome;
    
    @OneToMany(mappedBy = "unidade")
    private List<Membro> membros;

    public Unidade(String nome) {
        this.nome = nome;
        if (this.membros == null)
            this.membros = new ArrayList<>();
    }
    
    public Unidade(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Unidade(UnidadeSemMembrosForm chamado) {
        this.id = chamado.getId();
        this.nome = chamado.getNome();
    }

}
