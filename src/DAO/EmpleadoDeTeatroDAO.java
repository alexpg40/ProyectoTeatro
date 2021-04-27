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
 * @author DarkB
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
    
}
