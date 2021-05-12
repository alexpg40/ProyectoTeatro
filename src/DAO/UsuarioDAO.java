package DAO;

import java.sql.Connection;
import Entidades.Usuario;
import ConexionBD.ConexionBD;
import Entidades.Empleado;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

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

    public static ArrayList<Usuario> mostrarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Usuario");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("idUsuario");
                    String nombre = prs.getString("nombre");
                    String apellido = prs.getString("apellido");
                    String nif = prs.getString("nif");
                    String telefono = prs.getString("telefono");
                    String email = prs.getString("email");

                    Usuario u = new Usuario(id, nombre, apellido, nif, telefono, email);
                    usuarios.add(u);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(DAO.EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public static Usuario selecionarUsuario(String nombre) {
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
                    usuario = new Usuario(id, nombreUsuario, apellidoUsuario, NIF, telefono, email);
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

    public static void insertarUsuario(Usuario u) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombre = u.getNombre();
                String apellido = u.getApellidos();
                String nif = u.getNif();
                String telefono = u.getTelefono();
                String email = u.getEmail();
                String password = u.getPassword();

                String sql = "INSERT INTO usuario(nombre, apellido, nif, telefono, email, password)" + "\n"
                        + "VALUES('" + nombre + "','" + apellido + "','" + nif + "','" + telefono + "','" + email + "','" + password + "');";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
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
    }

    public static void verElementos(Usuario u) {

        int opcion = -1;
        do {
            System.out.println(" 1. Ver mis Bonos  " + "|" + " 2. Ver Franquicias " + "\n" + 
                    " 0. Salir");
            Scanner in;
            try {
                in = new Scanner(System.in);
                opcion = in.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nSolo se permiten numeros enteros entre 0 y 2");
                continue;
            }
            if (opcion < 0 || opcion > 2) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }

            switch (opcion) {

                case 1:
                    System.out.println("Has seleccionado ver tus bonos: ");
                    try {
                        if (conn == null || conn.isClosed()) {
                            conn = ConexionBD.establecerConexion();
                        }

                        Statement stmt = null;
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sqlRec = "SELECT b.*, u.nombre, u.apellido FROM bono as b, usuario as u WHERE b.idUsuario = u.idUsuario and";
                        sqlRec += " nombre='" + u.getNombre() + "'";
                        ResultSet rs = stmt.executeQuery(sqlRec);
                        while (rs.next()) {
                            int idBono = rs.getInt("idBono");
                            int mes = rs.getInt("mes");
                            String tipo = rs.getString("tipo");
                            String nombre = rs.getString("nombre");
                            String apellido = rs.getString("apellido");

                            System.out.println("El ID del bono es: " + idBono + ", el mes es: " + mes + "\n" + ", el tipo de bono es " + tipo + "\n"
                                    + "Este bono pertenece a:  " + nombre + apellido);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado ver las franquicias existentes: ");
                    try {
                        if (conn == null || conn.isClosed()) {
                            conn = ConexionBD.establecerConexion();
                        }

                        Statement stmt = null;
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sqlRec = "SELECT ubicacion, accesibilidad FROM Franquicia";
                        ResultSet rs = stmt.executeQuery(sqlRec);
                        while (rs.next()) {
                            String ubicacion = rs.getString("ubicacion");
                            int accesibilidad = rs.getInt("accesibilidad");
                            if (accesibilidad == 1) {
                                System.out.println("Hay una franquicia en: " + ubicacion + " y tiene una buena accesibilidad para personas con movilidad reducida.");
                            } else {
                                System.out.println("Hay una franquicia en: " + ubicacion + " y no tiene una buena accesibilidad para personas con movilidad reducida.");
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta...");
                    break;
            }

        } while (opcion < 0 || opcion
                > 2);
    }

    public static void eliminarUsuario(int id) {
        PreparedStatement pstmt = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                pstmt = conn.prepareStatement("DELETE FROM Usuario WHERE idUsuario = ?");
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void actualizarUsuario(Usuario u){
        PreparedStatement pstmt = null;
        Scanner in;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String nombre = u.getNombre(), apellido = u.getApellidos(), nif = u.getNif(), telefono = u.getTelefono(), email = u.getEmail();
                long idUsuario = u.getId();
                
                String nuevoNombre = null, nuevoApellido = null, nuevoNif = null, nuevoTelefono = null, nuevoEmail = null;
                
                System.out.println("Introduzca un nuevo nombre (no escriba nada y presione enter para no cambiarlo)");
                in = new Scanner (System.in);
                try {
                    nuevoNombre = in.nextLine();
                } catch (Exception e){
                    System.out.println("Ha surgido una exepción.");
                };
                if ((nombre.equals(u.getNombre())) || (nombre.isEmpty())) {
                    System.out.println("No se ha actualizado el nombre.");
                } else {
                    nombre = nuevoNombre;
                }
                
                System.out.println("Introduzca un nuevo apellido (no escriba nada y presione enter para no cambiarlo)");
                in = new Scanner (System.in);
                try {
                    nuevoApellido = in.nextLine();
                } catch (Exception e){
                    System.out.println("Ha surgido una exepción.");
                }
                if ((apellido.equals(u.getApellidos())) || (apellido.isEmpty())) {
                    System.out.println("No se ha actualizado el apellido.");
                } else {
                    apellido = nuevoApellido;
                }
                
                System.out.println("Introduzca un nuevo NIF (no escriba nada y presione enter para no cambiarlo)");
                in = new Scanner (System.in);
                try {
                    nuevoNif = in.nextLine();
                } catch (Exception e){
                    System.out.println("Ha surgido una exepción.");
                }
                if ((nif.equals(u.getNif())) || (nif.isEmpty())) {
                    System.out.println("No se ha actualizado el NIF.");
                } else {
                    nif = nuevoNif;
                }
                
                System.out.println("Introduzca un nuevo Telefono (no escriba nada y presione enter para no cambiarlo)");
                in = new Scanner (System.in);
                try {
                    nuevoTelefono = in.nextLine();
                } catch (Exception e){
                    System.out.println("Ha surgido una exepción.");
                }
                
                if ((telefono.equals(u.getNif())) || (telefono.isEmpty())) {
                    System.out.println("No se ha actualizado el Telefono.");
                } else {
                    telefono = nuevoTelefono;
                }
                
                System.out.println("Introduzca un nuevo Email (no escriba nada y presione enter para no cambiarlo)");
                in = new Scanner (System.in);
                try {
                    nuevoTelefono = in.nextLine();
                } catch (Exception e){
                    System.out.println("Ha surgido una exepción.");
                };
                if ((telefono.equals(u.getNif())) || (telefono.isEmpty())) {
                    System.out.println("No se ha actualizado el Email.");
                } else {
                    email = nuevoEmail;
                }
                
                pstmt = conn.prepareStatement("UPDATE Usuario SET nombre ='" +  nombre + "', apellido ='" + apellido + "', nif ='" + nif +
                        "', telefono ='" + telefono + "', email='"+ email  + "' WHERE idUsuario =" + idUsuario);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean comprobarCorreo (String correo) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String emailRecuperado = null;
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT email FROM usuario");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()){
                    emailRecuperado = prs.getString("email");
                    if (emailRecuperado.equals(correo)){
                        return true;
                    }
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
        return false;
    }
    
    public static boolean comprobarNIF (String NIF) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String nifRecuperado = null;
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT nif FROM usuario");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()){
                    nifRecuperado = prs.getString("nif");
                    if (nifRecuperado.equals(NIF)){
                        return true;
                    }
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
        return false;
    }

     public static boolean loggearUsuario (Usuario usu) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT nombre, apellido, nif, telefono, email, password FROM usuario WHERE email = ?");
                pstmt.setString(1, String.valueOf(usu.getEmail()));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {

                    if (usu.getPassword().equals(prs.getString("password"))){
                        usu.setNombre(prs.getString("nombre"));
                        usu.setApellidos(prs.getString("apellido"));
                        usu.setNif(prs.getString("nif"));
                        usu.setTelefono("telefono");
                        return true;
                    } else {
                        return false;
                    }
                }
                prs.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public static Usuario selecionarActual(String email) {
        Usuario usuario = null;

        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");
                pstmt.setString(1, String.valueOf(email));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    String nombreUsuario = prs.getString("nombre");
                    String apellidoUsuario = prs.getString("apellido");
                    String NIF = prs.getString("nif");
                    String telefono = prs.getString("telefono");
                    String emailRecuperado = prs.getString("email");
                    String password = prs.getString("password");
                    usuario = new Usuario(nombreUsuario, apellidoUsuario, NIF, telefono, emailRecuperado, password);
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
}
