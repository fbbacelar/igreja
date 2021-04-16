package br.com.fabio.igreja.controllers.form;

import br.com.fabio.igreja.models.Membro;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class MembroSemChamadosForm {
    
    @NotNull @NotEmpty
    private Long id;

    @NotNull @Length(min=5, max=255)
    private String nome;
    
    @NotNull @Length(min=1, max=1)
    private String sexo;


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

    
    public Membro converter(){
        return new Membro(id, nome, sexo);
    }

    
}
