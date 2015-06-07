/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pos.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author wanderson
 */
@Embeddable
public class Endereco {
    @Column(name="CP",nullable=true,length=20)
     private String cep;
    @Column(name="END",nullable=true,length=100)
    private String endereco;
    @Column(name="NUM",nullable=true,length=30)
    private String numero;
    @Column(name="BRR",nullable=true,length=200)
    private String bairro;
    @Column(name="CID",nullable=true,length=200)
    private String cidade;
    @Column(name="UF",nullable=true,length=3)
    private String estado;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
