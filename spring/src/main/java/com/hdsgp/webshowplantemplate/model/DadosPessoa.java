package com.hdsgp.webshowplantemplate.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class DadosPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dados_pessoa_id")
    private long id;
    @OneToOne
    private Pessoa pessoa;
    @OneToOne
    private TipoPessoa tipoPessoa;
    @Column(nullable = false, unique = true)
    private String numDocumento;
    @Column(nullable = false)
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public DadosPessoa(long id,
                       Pessoa pessoa,
                       TipoPessoa tipoPessoa,
                       String numDocumento,
                       Date dataNascimento,
                       Endereco endereco) {
        this.id = id;
        this.pessoa = pessoa;
        this.tipoPessoa = tipoPessoa;
        this.numDocumento = numDocumento;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public DadosPessoa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "DadosPessoa{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", tipoPessoa=" + tipoPessoa +
                ", numDocumento='" + numDocumento + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco=" + endereco +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pessoa, tipoPessoa, numDocumento, dataNascimento, endereco);
    }
}
