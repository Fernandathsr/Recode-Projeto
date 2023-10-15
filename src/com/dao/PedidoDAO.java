package com.dao;

import com.model.Cliente;
import com.model.Passagem;
import com.model.Pedido;
import com.dao.ClienteDAO;
import com.dao.PassageDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {

    ClienteDAO clienteDAO = new ClienteDAO();
    PassageDAO passageDAO = new PassageDAO();
    Connection con = null;

    public boolean createPedido(Pedido pedido) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "INSERT INTO pedido (valorPedido, dataPedido, fkIdCliente, fkIdPassagem) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, pedido.getValorPedido());
            stmt.setString(2, pedido.getDataPedido());
            stmt.setInt(3, pedido.getCliente().getIdCliente());
            stmt.setInt(4, pedido.getPassagem().getIdPassagem());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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

    // READ

    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "SELECT pedido.idPedido as cod_ped, pedido.valorPedido as val_ped, pedido.dataPedido as dat_ped, cliente.idCliente as id_c, " +
                    "passagem.idPassagem as id_p FROM pedido pedido INNER JOIN cliente cliente ON pedido.fkIdCliente = cliente.idCliente INNER JOIN passagem passagem ON pedido.fkIdPassagem = passagem.idPassagem";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setIdPedido(rs.getInt("cod_ped"));
                    pedido.setValorPedido(rs.getInt("val_ped"));
                    pedido.setDataPedido(rs.getString("dat_ped"));

                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id_c")); //PUXANDO O ID DO CLIENTE

                    pedido.setCliente(cliente); // SETANDO O CLIENTE NO OBJETO PEDIDO

                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(rs.getInt("id_p"));

                    pedido.setPassagem(passagem);

                    pedidos.add(pedido);

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
        return pedidos;
    }

    //UPDATE
    public boolean uptadePedido(Pedido pedido) {

        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = " UPDATE pedido SET  valorPedido = ?, dataPedido = ?, idCliente = ?, idPassagem = ? WHERE idPedido = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdPedido());
            stmt.setDouble(2, pedido.getValorPedido());
            stmt.setString(3, pedido.getDataPedido());
            stmt.setInt(4, pedido.getCliente().getIdCliente());
            stmt.setInt(5, pedido.getPassagem().getIdPassagem());
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

    public boolean deletePedido(Pedido pedido) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "DELETE FROM pedido WHERE idPedido = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdPedido());
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



