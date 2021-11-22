package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private float preco;

    @Column
    private String descricao;

    @OneToOne
    private TipoServico tipoServico;

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
        return "Servico{" +
                "id=" + id +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", tipoServico=" + tipoServico +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String setDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Servico() {
    }

    public Servico(long id, float preco, String descricao, TipoServico tipoServico) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.tipoServico = tipoServico;
    }
}
