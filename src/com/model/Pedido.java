package com.model;

public class Pedido {

    private int idPedido;
    private int valorPedido;
    private String dataPedido;
    private Cliente cliente;
    private Passagem  passagem;



    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(int valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }
}




