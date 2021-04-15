package br.com.fabio.igreja.controllers.form;

import br.com.fabio.igreja.models.Membro;
//import br.com.fabio.igreja.repositories.ChamadoRepository;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
//import java.util.List;

public class MembroForm {

    @NotNull @Length(min=5, max=255)
    private String nome;
    
    @NotNull @Length(min=1, max=1)
    private String sexo;

//    private List<ChamadoForm> chamados;


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

//    public List<ChamadoForm> getChamados() {
//        return chamados;
//    }
//
//    public void setChamados(List<ChamadoForm> chamados) {
//        this.chamados = chamados;
//    }
    
    public Membro converter(){
        return new Membro(nome, sexo);
    }
}
