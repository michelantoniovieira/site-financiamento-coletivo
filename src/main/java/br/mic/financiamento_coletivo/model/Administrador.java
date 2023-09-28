package br.mic.financiamento_coletivo.model;

import jakarta.persistence.*;

@Entity
public class Administrador
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="senha")
    private String senha;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getSenha()
    {
        return senha;
    }
    public void setSenha(String senha)
    {
        this.senha = senha;
    }

}

