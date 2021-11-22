package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "idLocal")
    private Local local;
    @Column(nullable = false)
    private boolean disponivel;

    public Disponibilidade(long id, Local local, boolean disponivel) {
        this.id = id;
        this.local = local;
        this.disponivel = disponivel;
    }

    public Disponibilidade() {
    }

    @Override
    public String toString() {
        return "Disponibilidade{" +
                "id=" + id +
                ", local=" + local +
                ", disponivel=" + disponivel +
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
