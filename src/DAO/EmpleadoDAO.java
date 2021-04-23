/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import Entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class EmpleadoDAO {

    private Empleado e;
    private static Connection conn;

    public static ArrayList<Empleado> todosEmpleados() {
        ArrayList<Empleado> ret = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Empleado");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idEmpleado");
                    String nombre = prs.getString("nombre");
                    String apellido = prs.getString("apellido");
                    String nif = prs.getString("nif");
                    String direccion = prs.getString("direccion");
                    String telefono = prs.getString("telefono");
                    long idFranquicia = prs.getLong("idFranquicia");
                    long idNomina = prs.getLong("idNonima");
                    Empleado e = new Empleado(id, nombre, apellido, nif, direccion, telefono, idFranquicia, idNomina);
                    ret.add(e);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public static void insertarEmpleado(Empleado e) {
        PreparedStatement pstmt = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("INSERT INTO Empleado VALUES (?,?,?,?,?,?,?,?)");
                long id = e.getId();
                String nombre = e.getNombre();
                String apellido = e.getApellidos();
                String nif = e.getNif();
                String direccion = e.getDireccion();
                String telefono = e.getTelefono();
                long idFranquicia = e.getIdfranquicia();
                long idNomina = e.getIdnomina();
                pstmt.setLong(1, id);
                pstmt.setString(2, nombre);
                pstmt.setString(3, apellido);
                pstmt.setString(4, nif);
                pstmt.setString(5, direccion);
                pstmt.setString(6, telefono);
                pstmt.setLong(7, idFranquicia);
                pstmt.setLong(8, idNomina);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eleminarEmpleado(int id){
        PreparedStatement pstmt = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("DELETE FROM Empleado WHERE idEmpleado = ?");
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
