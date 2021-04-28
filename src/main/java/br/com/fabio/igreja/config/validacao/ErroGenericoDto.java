package br.com.fabio.igreja.config.validacao;

public class ErroGenericoDto {
    
    private String erro;

    public ErroGenericoDto(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }
    
}
