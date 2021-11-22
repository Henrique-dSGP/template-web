package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;
@Entity
@Audited
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pessoa_id")
    private long id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private boolean verificado;
    @Column
    private boolean assinante;

    public Pessoa(long id, String nome, String sobrenome, String email, String senha, boolean verificado, boolean assinante) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.verificado = verificado;
        this.assinante = assinante;
    }

    public Pessoa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public boolean getAssinante(){return assinante;}

    public void setAssinante(boolean assinante){ this.assinante = assinante;}

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", verificado=" + verificado + '\'' +
                ", assinante=" + assinante +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
