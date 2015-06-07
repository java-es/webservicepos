package br.com.pos.modelo;

/**
 *
 * @author wanderson
 */
public class Resposta {
   private String codigo;
   private String mensagem;
   private boolean isErro;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isIsErro() {
        return isErro;
    }

    public void setIsErro(boolean isErro) {
        this.isErro = isErro;
    }
}
