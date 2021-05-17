package DAO;

import ConexionBD.ConexionBD;
import Entidades.Bono;
import Entidades.Usuario;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BonoDAO {

    private Bono bono;
    private static Connection conn;

    public static int seleccionarIdUsuario(String correo) {
        int id;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                int idRecuperada = -1;
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT idUsuario FROM Usuario WHERE email='" + correo + "'");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    idRecuperada = prs.getInt("idUsuario");
                    id = idRecuperada;
                    return id;
                }
                prs.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static void insertarBono(String correo, String tipo) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                
                int mes = LocalDate.now().getMonthValue();
                int idUsuarioRecuperado = BonoDAO.seleccionarIdUsuario(correo);

                PreparedStatement pstmt = null;

                String sql = "INSERT INTO Bono (mes, tipo, idUsuario)" + "\n"
                        + "VALUES('" + mes + "','" + tipo + "','" + idUsuarioRecuperado + "');";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
