package com.hdsgp.webshowplantemplate.model;

import javax.persistence.*;

@Entity
public class TipoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String tipo;

    public TipoPessoa(long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoPessoa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "TipoPessoa{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
