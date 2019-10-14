package br.com.fiap.lince;

public class Compra {

    private int id;

    private int idUsuario;

    private String dataCompra;

    private Double valor;

    public Compra() {
    }

    public Compra(int id, int idUsuario, String dataCompra, Double valor) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataCompra = dataCompra;
        this.valor = valor;
    }

    public Compra(int idUsuario, String dataCompra, Double valor) {
        this.idUsuario = idUsuario;
        this.dataCompra = dataCompra;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
