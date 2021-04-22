package br.com.fabio.igreja.controllers.form;

import br.com.fabio.igreja.models.Unidade;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UnidadeSemMembrosForm {

    @NotNull @NotEmpty
    private Long id;
    
    @NotNull @Length(min=5, max=255)
    private String nome;
    
    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public Unidade converter(){
        return new Unidade(id, nome);
    }
}
