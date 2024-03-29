package br.com.fiap.lince;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;

    private String nome;

    private String email;

    private String senha;

    private Double saldo;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha, Double saldo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
    }

    public Usuario(String nome, String email, String senha, Double saldo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;

    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
