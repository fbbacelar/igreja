package br.com.fabio.igreja.models;

import br.com.fabio.igreja.controllers.form.ChamadoSemMembrosForm;
import br.com.fabio.igreja.controllers.form.MembroSemChamadosForm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="Chamado")
@Table(name="chamado")
public class Chamado implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany(mappedBy = "chamados")
    private List<Membro> membros;
    
    public Chamado() {
    }

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
        Chamado other = (Chamado) obj;
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

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }
}
