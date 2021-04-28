package br.com.fabio.igreja.controllers.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.fabio.igreja.models.Papeleta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PapeletaForm {

    @NotNull
    @NotEmpty
    private List<DoacaoForm> doacoes;

    @NotNull
    private PapeletaMembroForm membro;
    
    public Papeleta converter(){
        return new Papeleta(this);
    }

    //Papelate não pode ser atualizada.    
    // public Papeleta atualizar(Papeleta papeleta){
    //     papeleta.getDoacoes().addAll(c);
    //     papeleta.setMembro(new Membro(membro.getNome(), membro.getSexo()));
    //     return papeleta;
    // }
}
