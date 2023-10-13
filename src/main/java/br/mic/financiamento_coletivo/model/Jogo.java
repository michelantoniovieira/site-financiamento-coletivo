package br.mic.financiamento_coletivo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class Jogo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jogo;


    @Column(name = "fk_id_rifa")
    private int fk_id_rifa;
    @Column(name="numero_escolhido")
    private String numero_escolhido;
    @Column(name="nome_participante")
    private String nome_participante;
    @Column(name="sobrenome")
    private String sobrenome;
    @Column(name="email")
    private String email;
    @Column(name="telefone")
    private String telefone;

    public Jogo() {
        // Construtor padrão vazio
    }

    public Jogo(int fk_id_rifa, String numero_escolhido, String nome_participante, String sobrenome, String email, String telefone)
    {
        this.fk_id_rifa = fk_id_rifa;
        this.numero_escolhido = numero_escolhido;
        this.nome_participante = nome_participante;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId_jogo()
    {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo)
    {
        this.id_jogo = id_jogo;
    }

    public int getFk_id_rifa()
    {
        return fk_id_rifa;
    }

    public void setFk_id_rifa(int fk_id_rifa)
    {
        this.fk_id_rifa = fk_id_rifa;
    }

    public String getNumero_escolhido()
    {
        return numero_escolhido;
    }

    public void setNumero_escolhido(String numero_escolhido)
    {
        this.numero_escolhido = numero_escolhido;
    }

    public String getNome_participante()
    {
        return nome_participante;
    }

    public void setNome_participante(String nome_participante)
    {
        this.nome_participante = nome_participante;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
}
