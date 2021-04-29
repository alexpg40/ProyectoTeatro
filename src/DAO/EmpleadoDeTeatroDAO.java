/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import Entidades.Empleado;
import Entidades.EmpleadoDeTeatro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class EmpleadoDeTeatroDAO {
    
    private EmpleadoDeTeatro e;
    private static Connection conn;
    
    public static ArrayList<EmpleadoDeTeatro> todosEmpleadosTeatro(){
        ArrayList<EmpleadoDeTeatro> ret = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet prs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("SELECT * FROM EmpleadoDeTeatro");
                prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idEmpleadoDeTeatro");
                    Empleado e = EmpleadoDAO.getEmpleadoById(id);
                    char categoria = prs.getString("categoria").charAt(0);
                    long idGrupoDeTrabajo = prs.getLong("idGrupoDeTrabajo");
                    EmpleadoDeTeatro et = new EmpleadoDeTeatro(e, categoria, idGrupoDeTrabajo);
                    ret.add(et);
                }
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
                if (prs != null) {
                    prs.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ret;}
    
    public static void eleminarEmpleadoDeTeatro(int id){
        PreparedStatement pstmt = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                EmpleadoDAO.eliminarEmpleado(id);
                pstmt = conn.prepareStatement("DELETE FROM EmpleadoDeTeatro WHERE idEmpleadoDeTeatro = " + id);
                pstmt.execute();
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
    
    public static void insertarEmpleadoDeTeatro(EmpleadoDeTeatro e){
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
                char categoria = e.getCategoria();
                long idGrupo = e.getIdGrupoDeTeatro();
                pstmt.setLong(1, id);
                pstmt.setString(2, nombre);
                pstmt.setString(3, apellido);
                pstmt.setString(4, nif);
                pstmt.setString(5, direccion);
                pstmt.setString(6, telefono);
                pstmt.setLong(7, idFranquicia);
                pstmt.setLong(8, idNomina);
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement("INSERT INTO EmpleadoDeTeatro VALUES ('" + id + "', '" + categoria + "', '" + idGrupo + "'");
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
