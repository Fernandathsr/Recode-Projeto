package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Cliente;

public class ClienteDAO {

    Connection con = null;


    //CREATE
    public boolean createCliente(Cliente cliente) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "INSERT INTO cliente (nomeCliente,cpfCliente,emailCliente,enderecoCliente,telefone) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setString(3, cliente.getEmailCliente());
            stmt.setString(4, cliente.getEnderecoCliente());
            stmt.setString(5, cliente.getTelefone());
            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    //READ
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            //Carrega o driver especificado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!"+ e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "SELECT * FROM cliente";
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNomeCliente(rs.getString("nomeCliente"));
                    cliente.setCpfCliente(rs.getString("cpfCliente"));
                    cliente.setEmailCliente(rs.getString("emailCliente"));
                    cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
                    cliente.setTelefone(rs.getString("telefone"));
                    clientes.add(cliente);

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return clientes;
    }

    //UPDATE
    public boolean updateCliente(Cliente cliente) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, emailCliente = ?, telefoneCliente = ? WHERE idCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setString(3, cliente.getEnderecoCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefone());
            stmt.setInt(6, cliente.getIdCliente());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //DELETE
    public boolean deleteCliente(Cliente cliente) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "DELETE FROM cliente WHERE idCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}

