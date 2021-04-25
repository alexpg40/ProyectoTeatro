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
                    int idBono = prs.getInt("idBono");

                    Usuario u = new Usuario(id, nombre, apellido, nif, telefono, email, idBono);
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
                        + "VALUES(" + id + ",'" + nombre + "','" + apellido + "','" + nif + "','" + telefono + "','" + email + "'," + idBono + ")";
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

    public static void verElementos() {

        int opcion = -1;
        do {
            System.out.println(" \b 0. Salir " + "\n" + " 1. Ver Acomodadores   " + "|" + "   2. Ver Beneficios" + "\n"
                    + " 3. Ver Bonos   " + "|" + "   4. Ver Costes" + "\n"
                    + " 5. Ver Empl.Dirección   " + "|" + "   6. Ver Empleados" + "\n"
                    + " 7. Ver Empl.Oficina   " + "|" + "   8. Ver Empl.Teatro" + "\n"
                    + " 9. Ver Franquicias   " + "|" + "   10. Ver Grupos de Trabajo" + "\n"
                    + " 11. Ver Informes   " + "|" + "   12. Ver Emp.Limpieza" + "\n"
                    + " 13. Ver Nominas   " + "|" + "   14. Ver Secretarios" + "\n"
                    + "15. Ver Taquilleros   " + "|" + "   16. Ver usuarios");
            Scanner in;
            try {
                in = new Scanner(System.in);
                opcion = in.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nSolo se permiten numeros enteros entre 0 y 16");
                continue;
            }
            if (opcion < 0 || opcion > 16) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }

            switch (opcion) {

                case 1:
                    System.out.println("Has seleccionado ver acomodadores: ");
                    try {
                        if (conn == null || conn.isClosed()) {
                            conn = ConexionBD.establecerConexion();
                        }

                        Statement stmt = null;
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sqlRec = "SELECT a.idAcomodador, e.idEmpleado, e.nombre, e.apellido, e.nif FROM acomodador as a, empleado as e WHERE a.idAcomodador = e.idEmpleado";
                        ResultSet rs = stmt.executeQuery(sqlRec);
                        while (rs.next()) {
                            long idAcomodador = rs.getInt("idAcomodador");
                            String idEmpleado = rs.getString("idEmpleado");
                            String nombre = rs.getString("nombre");
                            String apellido = rs.getString("apellido");
                            String nif = rs.getString("nif");

                            System.out.println("El ID del acomodador es: " + idAcomodador + ", el ID del EMPLEADO es: " + idEmpleado + "\n"
                                    + "El empleado se llama " + nombre + apellido + ", con el NIF:" + nif);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                default:
                    System.out.println("Opción incorrecta...");
                    break;
            }

        } while (opcion < 0 || opcion
                > 16);
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

}
