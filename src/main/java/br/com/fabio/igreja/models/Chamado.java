package br.com.fabio.igreja.models;

import br.com.fabio.igreja.controllers.form.ChamadoSemMembrosForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity(name="Chamado")
@Table(name="chamado")
@Data
@NoArgsConstructor
public class Chamado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Length(min = 3, max = 80)
    private String nome;
    
    @ManyToMany(mappedBy = "chamados")
    private List<Membro> membros;
    
    public Chamado(String nome) {
        this.nome = nome;
        if (this.membros == null)
            this.membros = new ArrayList<>();
    }
    
    public Chamado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Chamado(ChamadoSemMembrosForm chamado) {
        this.id = chamado.getId();
        this.nome = chamado.getNome();
    }

}
