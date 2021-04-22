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

@Entity(name="Unidade")
@Table(name="unidade")
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Length(min = 3, max = 80)
    private String nome;
    
    @OneToMany(mappedBy = "unidade")
    private List<Membro> membros;
    
    public Unidade() {
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Unidade other = (Unidade) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Membro> getMembros() {
        return membros;
    }
}
