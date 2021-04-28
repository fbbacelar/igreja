package br.com.fabio.igreja.controllers.form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.models.Chamado;

public class ChamadoForm {

    @NotNull @Length(min=5, max=80)
    private String nome;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Chamado converter(){
        return new Chamado(nome);
    }

    public Chamado atualizar(Chamado chamado){
        chamado.setNome(this.nome);
        return chamado;
    }
}
