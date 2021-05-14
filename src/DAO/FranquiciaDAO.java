package DAO;

import ConexionBD.ConexionBD;
import Entidades.Franquicia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FranquiciaDAO {
    private Franquicia f;
    private static Connection conn;
    
    public static String[][] seleccionarFranquicias () {
       String[][] franquicias = null;
       try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                ArrayList<String> ubicacion = new ArrayList();
                ArrayList<String> accesibilidad = new ArrayList();
                String aux = "";
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT ubicacion, accesibilidad FROM Franquicia");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()){
                    if (prs.getInt("accesibilidad") == 1) {
                        aux = "Si";
                        accesibilidad.add(aux);
                    } else {
                        aux = "No";
                        accesibilidad.add(aux);
                    }
                    ubicacion.add(prs.getString("ubicacion"));
                }
                
                String[] ubicacionArray = new String[ubicacion.size()];
                ubicacionArray = ubicacion.toArray(ubicacionArray);
                
                String[] accesibilidadArray = new String[ubicacion.size()];
                accesibilidadArray = accesibilidad.toArray(accesibilidadArray);
                
                franquicias = new String[ubicacion.size()][2];

                for (int i = 0; i < ubicacion.size();i++){
                    franquicias[i][0] = ubicacionArray[i];
                    franquicias[i][1] = accesibilidadArray[i];
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
        return franquicias;
    }
}
