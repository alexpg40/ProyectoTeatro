/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import Entidades.Informe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandr
 */
public class InformeDAO {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Informe inf;
    private static Connection conn;

    public InformeDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public InformeDAO(Informe i) {
        this.inf = i;
        conn = ConexionBD.establecerConexion();
    }

    /**
     * Función que mediante un Select selecciona todos los elementos de una
     * entidad (ver todos).
     *
     * @return todosLosInformes
     */
    public ArrayList<Informe> todosLosInformes() {
        ArrayList<Informe> todosLosInformes = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Informe");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idInforme");
                    Informe informe = new Informe(); //MIRAR CONSTRUCTOR
                    todosLosInformes.add(informe);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosLosInformes;
    }

    /**
     * Función que mediante un Insert into, values crea nuevos elementos a
     * partir de los valores introducidos por el usuario.
     *
     * @param inf
     * @return inf
     */
    public Informe crearInforme(Informe inf) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                long idSecretariado = inf.getIdSecretariado();

                String sql = "INSERT INTO Informe(idSecretariado) VALUES('" + idSecretariado + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM Informe WHERE ";
                sqlRec += " idSecretariado: '" + idSecretariado + "'";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    int id = rs.getInt("idInforme");
                    idSecretariado = rs.getLong("idSecretariado");
                    inf = new Informe(); //MIRAR CONSTRUCTOR
                    return inf;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
                inf = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inf;
    }

    /**
     *
     * @param inf
     */
    public void verDetallesInforme(Informe inf) {

    }

    /**
     *
     * @param inf
     */
    public void modificarInforme(Informe inf) {
try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                Date mesyano = inf.getMesyano();
                long idSecretariado = inf.getIdSecretariado();
                long idFranquicia = inf.getIdfranquicia();
                double balance = inf.getBalance();
                

                String sql = "UPDATE Informe SET ";
                sql += "mesyano='" + mesyano + "'";
                sql += ", idSecretariado='" + idSecretariado + "'";
                sql += ", idFranquicia=" + idFranquicia;
                sql += ", balance=" + balance;

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(inf.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Función que mediante un Delete elimina alguno o varios elemento/s ya
     * existentes en la BD y que ha seleccionado el usuario.
     *
     * @param inf
     */
    public void eliminarInforme(int idInforme) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM Informe WHERE id = ?");
                pstmt.setString(1, String.valueOf(idInforme));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el informe de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se ha eliminado el informe de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InformeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
