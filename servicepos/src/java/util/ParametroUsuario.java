package util;

import br.com.pos.modelo.Usuario;

/**
 *
 * @author wanderson
 */
public class ParametroUsuario {
    private Usuario usuario;
    private String chave;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
