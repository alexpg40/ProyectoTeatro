/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

import java.util.ArrayList;
public class Usuario {
    
    private long ID;
    private String nombre;
    private String apellidos;
    private String NIF;
    private String telefono;
    private String email;
    private ArrayList<Bono> bono = new ArrayList <Bono>();
    
    public Usuario(){
}
    public String setNombre(){
        return nombre;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
            String mensaje = "El usuario"+ " " + nombre + " " + apellidos + " " + "con DNI" + " " + NIF;
        return mensaje;
        }   
}
