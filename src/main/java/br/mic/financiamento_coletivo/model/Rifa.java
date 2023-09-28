package br.mic.financiamento_coletivo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Rifa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rifa;
    @Column(name="preco")
    private BigDecimal preco;
    @Column(name="premio")
    private String premio;
    @Column(name="regulamento")
    private String regulamento;
    @Column(name="quantidade_numeros_rifa")
    private int quantidade_numeros_rifa;

    public Rifa(BigDecimal preco, String premio, String regulamento, int quantidade_numeros_rifa)
    {
        this.preco = preco;
        this.premio = premio;
        this.regulamento = regulamento;
        this.quantidade_numeros_rifa = quantidade_numeros_rifa;
    }

    public int getId_rifa()
    {
        return id_rifa;
    }

    public void setId_rifa(int id_rifa)
    {
        this.id_rifa = id_rifa;
    }

    public BigDecimal getPreco()
    {
        return preco;
    }

    public void setPreco(BigDecimal preco)
    {
        this.preco = preco;
    }

    public String getPremio()
    {
        return premio;
    }

    public void setPremio(String  premio)
    {
        this.premio = premio;
    }

    public String getRegulamento()
    {
        return regulamento;
    }

    public void setRegulamento(String regulamento)
    {
        this.regulamento = regulamento;
    }

    public int getQuantidade_numeros_rifa()
    {
        return quantidade_numeros_rifa;
    }

    public void setQuantidade_numeros_rifa(int quantidade_numeros_rifa)
    {
        this.quantidade_numeros_rifa = quantidade_numeros_rifa;
    }
}
