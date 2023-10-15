package com.model;

public class Cliente {

    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String emailCliente;
    private String enderecoCliente;
    private String telefone;



    public Cliente(){

    }

    public Cliente(String nomeCliente, String cpfCliente,String emailCliente, String enderecoCliente, String telefone) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.enderecoCliente = enderecoCliente;
        this.telefone = telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
       return cpfCliente;
   }

      public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
     }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
