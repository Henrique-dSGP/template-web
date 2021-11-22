package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class CidadeAtuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private UF uf;
    @Column(nullable = false)
    private String nome;

    public CidadeAtuacao(long id, UF uf, String nome) {
        this.id = id;
        this.uf = uf;
        this.nome = nome;
    }

    public CidadeAtuacao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CidadeAtuacao{" +
                "id=" + id +
                ", uf=" + uf +
                ", nome='" + nome + '\'' +
                '}';
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
