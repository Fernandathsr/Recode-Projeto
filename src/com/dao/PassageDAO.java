package com.dao;

import com.model.Passagem;
import com.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassageDAO {

    Connection con = null;


    //CREATE PASSAGEM

    public boolean createPasssagem(Passagem passagem) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "INSERT INTO passagem (destinoViagem) VALUES (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, passagem.getDestinoViagem());
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
    public List<Passagem> findAll() {
        List<Passagem> passagens = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "SELECT * FROM passagem";
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(rs.getInt("idPassagem"));
                    passagem.setDestinoViagem(rs.getString("destinoViagem"));
                    passagens.add(passagem);
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
        return passagens;
    }

    // UPDATE

    public boolean updatePassagem(Passagem passagem) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "UPDATE passagem SET  destinoViagem = ? WHERE idPassagem = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, passagem.getDestinoViagem());
            stmt.setInt(2, passagem.getIdPassagem());

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
    public boolean deletePassagem(Passagem passagem) {
        try {
            String url = "jdbc:mysql://localhost:3306/agencia";
            con = DriverManager.getConnection(url, "root" , "root");
            String sql = "DELETE FROM passagem WHERE idPassagem = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, passagem.getIdPassagem());
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


