package dao;

import java.sql.Connection;
import Entidades.Usuario;
import ConexionBD.ConexionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    private Usuario u;
    private static Connection conn;
    
    public UsuarioDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public UsuarioDAO(Usuario us) {
        this.u = us;
        conn = ConexionBD.establecerConexion();
    }
    
    public static Usuario selecionarUsuarios(String nombre) {
        Usuario usuario = null;

        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM usuario WHERE nombre = ?");
                pstmt.setString(1, String.valueOf(nombre));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("idUsuario");
                    String nombreUsuario = prs.getString("nombre");
                    String apellidoUsuario = prs.getString("apellido");
                    String NIF = prs.getString("nif");
                    String telefono = prs.getString("telefono");
                    String email = prs.getString("email");
                    int idBono = prs.getInt("idBono");
                    usuario = new Usuario(id, nombreUsuario, apellidoUsuario, NIF, telefono, email, idBono);
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
        return usuario;
    }
    
     public static Usuario insertarUsuario(Usuario u) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                
                long id = u.getId();
                String nombre = u.getNombre();
                String apellido = u.getApellidos();
                String nif = u.getNif();
                String telefono = u.getTelefono();
                String email = u.getEmail();
                int idBono = u.getIdBono();
                                   
                String sql = "INSERT INTO usuario(idUsuario, nombre, apellido, nif, telefono, email, idBono) "
                + "VALUES(" + id + ",'" + nombre + "','" + apellido + "','" + nif + "','" + telefono + "','" + email + "',"+ idBono +")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                
                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM usuario WHERE ";
                sqlRec += " nombre='" + nombre + "'";
                sqlRec += " ORDER BY idUsuario DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long idUsuarioInsertado = rs.getLong("idUsuario");
                    String nombreUsuarioInsertado = rs.getString("nombre");
                    String apellidoUsuarioInsertado = rs.getString("apellido");
                    String nifUsuarioInsertado = rs.getString("nif");
                    String telefonoUsuarioInsertado = rs.getString("telefono");
                    String emailUsuarioInsertado = rs.getString("email");
                    int idBonoUsuarioInsertado = rs.getInt("idBono");
                    u = new Usuario(idUsuarioInsertado, nombreUsuarioInsertado, apellidoUsuarioInsertado, nifUsuarioInsertado, telefonoUsuarioInsertado, emailUsuarioInsertado, idBonoUsuarioInsertado);
                    return u;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                u = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
}
