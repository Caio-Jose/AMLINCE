package br.com.fiap.lince;

public class Bilhete {

    private int id;

    private String descricacao;

    private Double saldo;

    private TipoBilhete tipo;

    public Bilhete() {
    }

    public Bilhete(int id, String descricacao, Double saldo, TipoBilhete tipo) {
        this.id = id;
        this.descricacao = descricacao;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public Bilhete(String descricacao, Double saldo, TipoBilhete tipo) {
        this.descricacao = descricacao;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public TipoBilhete getTipo() {
        return tipo;
    }

    public void setTipo(TipoBilhete tipo) {
        this.tipo = tipo;
    }
}
