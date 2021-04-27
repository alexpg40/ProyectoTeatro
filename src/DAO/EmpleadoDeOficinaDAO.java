/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexionBD;
import DAO.EmpleadoDAO;
import Entidades.Empleado;
import Entidades.EmpleadoDeOficina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DarkB
 */
public class EmpleadoDeOficinaDAO {
    
    private EmpleadoDeOficina e;
    private static Connection conn;
    
    public static ArrayList<EmpleadoDeOficina> todosEmpleadosOficina(){
        ArrayList<EmpleadoDeOficina> ret = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet prs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("SELECT * FROM EmpleadoDeOficina");
                prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idEmpleadoDeOficina");
                    Empleado e = EmpleadoDAO.getEmpleadoById(id);
                    int añosPlantilla = prs.getInt(2);
                    EmpleadoDeOficina eo = new EmpleadoDeOficina(e, añosPlantilla);
                    ret.add(eo);
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
    
    public static EmpleadoDeOficina getEmpleadoDeOficinaById(int id){
        EmpleadoDeOficina ret = new EmpleadoDeOficina();
        PreparedStatement pstmt = null;
        ResultSet prs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("SELECT * FROM EmpleadoDeOficina WHERE idEmpleadoDeOficina = " + id);
                prs = pstmt.executeQuery();
                while (prs.next()) {
                    int idEmpleadoDeOficina = prs.getInt("idEmpleadoDeOficina");
                    Empleado e = EmpleadoDAO.getEmpleadoById(idEmpleadoDeOficina);
                    int añosPlantilla = prs.getInt(2);
                    ret = new EmpleadoDeOficina(e, añosPlantilla);
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
    
    public static ArrayList<EmpleadoDeOficina> getEmpleadoDeOficinaByNombre(String nombre){
        ArrayList<EmpleadoDeOficina> ret = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet prs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("SELECT * FROM EmpleadoDeOficina");
                prs = pstmt.executeQuery();
                while (prs.next()) {
                    int idEmpleadoDeOficina = prs.getInt("idEmpleadoDeOficina");
                    int añosPlantilla = prs.getInt(2);
                    ArrayList<Empleado> empleados = EmpleadoDAO.getEmpleadoByNombre(nombre);
                    for (Empleado e : empleados) {
                        long idEmpleado = e.getId();
                        if (idEmpleadoDeOficina == idEmpleado) {
                            EmpleadoDeOficina eo = new EmpleadoDeOficina(e, añosPlantilla);
                            ret.add(eo);
                        }
                    }
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
    
    public static void actualizarEmpleadoDeOficina(EmpleadoDeOficina e){
        PreparedStatement pstmt = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                long id = e.getId();
                String nombre = e.getNombre();
                String apellido = e.getApellidos();
                String direccion = e.getDireccion();
                String nif = e.getNif();
                long idFranquicia = e.getIdfranquicia();
                long idNomina = e.getIdnomina();
                long añosPlantilla = e.getAñosPlantilla();
                EmpleadoDAO.actualizarEmpleado(e);
                pstmt = conn.prepareStatement("UPDATE EmpleadoDeOficina SET aniosPlantilla = '" + añosPlantilla + "' WHERE idEmpleadoDeOficina = " + id);
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
    
    public static void eleminarEmpleadoDeOficina(int id){
        Empleado e = EmpleadoDAO.getEmpleadoById(id);
        EmpleadoDAO.elminarEmpleado(id);
        PreparedStatement pstmt = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("DELETE FROM EmpleadoDeOficina WHERE idEmpleadoDeOficina = ?");
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
