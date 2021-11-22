package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "endereco_id")
    private long id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String siglaEstado;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String cep;

    public Endereco(long id, String numero, String rua, String bairro, String cidade, String siglaEstado, String pais, String cep) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.siglaEstado = siglaEstado;
        this.pais = pais;
        this.cep = cep;
    }

    public Endereco() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
