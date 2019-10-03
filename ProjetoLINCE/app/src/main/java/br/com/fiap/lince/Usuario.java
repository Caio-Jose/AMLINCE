package br.com.fiap.lince;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;

    private String nome;

    private String email;

    private String senha;

    private Bilhete bilhete;

    private Boolean Admin;

    public Usuario() {
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public Usuario(String nome, String email, String senha, Bilhete bilhete, Boolean admin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bilhete = bilhete;
        Admin = admin;
    }

    public Usuario(int id, String nome, String email, String senha, Bilhete bilhete, Boolean admin) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bilhete = bilhete;
        Admin = admin;
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

    public Boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(Boolean admin) {
        Admin = admin;
    }
}
