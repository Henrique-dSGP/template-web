package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nome;

    public TipoServico() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "TipoServico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public TipoServico(long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
