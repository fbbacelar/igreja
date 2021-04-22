package br.com.fabio.igreja.controllers.form;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.models.Unidade;

public class MembroForm {

    @NotNull @Length(min=5, max=255)
    private String nome;
    
    @NotNull @Length(min=1, max=1)
    private String sexo;

    private List<ChamadoSemMembrosForm> chamados;

    private Unidade unidade;


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

    public List<ChamadoSemMembrosForm> getChamados() {
        return chamados;
    }

    public void setChamados(List<ChamadoSemMembrosForm> chamados) {
        this.chamados = chamados;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Membro converter(){
        return new Membro(nome, sexo, chamados, unidade);
    }

    public Membro atualizar(Membro membro){
        membro.setNome(this.nome);
        membro.setSexo(this.sexo);
        return membro;
    }
}
