package br.com.pos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wanderson
 */
@Entity
@Table(name="T_CLT")
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name="ID_CLT")
    private Long idCliente;
   @Column(name="NOM",nullable=true,length=200)
   private String nome;
   @Column(name="CPFCNPJ",nullable=true,length=15)
   private String cnpj;
   @Column(name="EML",nullable=true,length=100)
    private String email;
   @Column(name="TEL",nullable=true,length=30)
    private String telefone;
   @OneToOne
   private Usuario usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
