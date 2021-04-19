package br.com.fabio.igreja.controllers.form;

import br.com.fabio.igreja.models.Chamado;
// import br.com.fabio.igreja.models.Membro;
// import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
//import java.util.List;

public class ChamadoSemMembrosForm {

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

    public Chamado converter(){
        return new Chamado(id, nome);
    }
}
