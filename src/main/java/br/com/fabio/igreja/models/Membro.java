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
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.controllers.form.ChamadoSemMembrosForm;

@Entity(name="Membro")
@Table(name="membro")
public class Membro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Length(min = 3, max = 80)
    private String nome;
    
    @Length(min = 1, max = 1)
    private String sexo;
    
    @ManyToMany
    private List<Chamado> chamados;

    @ManyToOne
    private Unidade unidade;

    public Membro() {
    }

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
        Membro other = (Membro) obj;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}