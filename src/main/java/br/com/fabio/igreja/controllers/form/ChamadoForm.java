package br.com.fabio.igreja.controllers.form;

import br.com.fabio.igreja.models.Chamado;
// import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
//import java.util.List;

public class ChamadoForm {

    @NotNull @Length(min=5, max=255)
    private String nome;
    
    // private List<MembroSemChamadosForm> membros;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Chamado converter(){
        return new Chamado(nome);
    }
}
