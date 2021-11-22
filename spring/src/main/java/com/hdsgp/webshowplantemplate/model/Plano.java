package com.hdsgp.webshowplantemplate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String titulo;

    @ManyToOne(cascade=CascadeType.MERGE)
    private CidadeAtuacao cidadeAtuacao;

    @Column
    private boolean ativo;

    @Column
    private float valor;

    @Column
    private String descricao;

    public Plano(long id, String titulo, CidadeAtuacao cidadeAtuacao, boolean ativo, float valor, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.cidadeAtuacao = cidadeAtuacao;
        this.ativo = ativo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Plano() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo(){ return titulo;}

    public void setTitulo(String titulo){this.titulo = titulo;}

    public CidadeAtuacao getCidadeAtuacao() {
        return cidadeAtuacao;
    }

    public void setCidadeAtuacao(CidadeAtuacao cidadeAtuacao) {
        this.cidadeAtuacao = cidadeAtuacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public float getValor(){
        return this.valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                "titulo=" + titulo +
                ", cidadeAtuacao=" + cidadeAtuacao +
                ", ativo=" + ativo +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
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
