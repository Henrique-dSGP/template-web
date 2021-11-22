package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLocal")
    private long id;
    @ManyToOne(cascade=CascadeType.MERGE)
    private UF uf;
    @ManyToOne(cascade=CascadeType.MERGE)
    private Cidade cidade;

    public Local(long id, UF uf, Cidade cidade) {
        this.id = id;
        this.uf = uf;
        this.cidade = cidade;
    }

    public Local() {
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
        return "Local{" +
                "id=" + id +
                ", uf=" + uf +
                ", cidade=" + cidade + '\'' +
                '}';
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
