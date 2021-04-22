package br.com.fabio.igreja.controllers.form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.models.Unidade;

public class UnidadeForm {

    @NotNull @Length(min=5, max=255)
    private String nome;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Unidade converter(){
        return new Unidade(nome);
    }

    public Unidade atualizar(Unidade unidade){
        unidade.setNome(this.nome);
        return unidade;
    }
}
