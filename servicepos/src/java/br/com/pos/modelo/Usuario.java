package br.com.pos.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author wanderson
 */
@Entity
@Table(name="T_USR")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name="ID_USR")
    private Long idUsuario;
    @Column(name="LGN",nullable=false,length=200)
    private String login;
    @Column(name="SNH",nullable=false,length=20)
    private String senha;
    @Transient
    private byte autenticado;
    
    public Usuario(){
    this.idUsuario = (long)0;
    this.login ="";
    this.senha = "";
    this.autenticado =0;
    }
   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(byte autenticado) {
        this.autenticado = autenticado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
