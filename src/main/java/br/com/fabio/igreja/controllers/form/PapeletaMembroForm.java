package br.com.fabio.igreja.controllers.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.fabio.igreja.models.Membro;
import br.com.fabio.igreja.models.Unidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PapeletaMembroForm {

    @NotNull @NotEmpty
    private Long id;

    @NotNull @Length(min=5, max=80)
    private String nome;
    
    @NotNull @Length(min=1, max=1)
    private String sexo;

    private List<ChamadoSemMembrosForm> chamados;

    private Unidade unidade;

    public Membro converter(){
        return new Membro(this);
    }

    public Membro atualizar(Membro membro){
        membro.setNome(this.nome);
        membro.setSexo(this.sexo);
        return membro;
    }
}
