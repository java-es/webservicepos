package br.com.pos.modelo;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name="T_FUNC")
public class Funcionario {

   @Id
   @GeneratedValue
   @Column(name="ID_FUNC")
   private Long idFuncionario;
   @Column(name="NOM",nullable=false,length=200)
   private String nome;
   @Column(name="CPF",nullable=false,length=200)
   private String cpf;
   @Column(name="EML",nullable=true,length=200)
   private String email;
   @Column(name="TEL",nullable=true,length=30)
   private String telefone;
   @Embedded
   private Endereco endereco;
   @OneToOne
   private Usuario usuario;
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
