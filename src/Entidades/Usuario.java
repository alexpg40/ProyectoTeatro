/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Sandr
 */
public class Usuario {
    private long id;
    private String nombre;
    private String apellidos;
    private String nif;
    private String telefono;
    private String email;   
    //Los usuarios pueden tener muchos bonos
    private ArrayList<Bono> bonos = new ArrayList<>();
    
    
    public Usuario () {
        
    }
    
    public Usuario (long id, String nombre, String apellidos, String nif, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.telefono = telefono;
        this.email = email;
    }
    
     public Usuario (Usuario usu){
        this.id = usu.id;
        this.nombre = usu.nombre;
        this.apellidos = usu.apellidos;
        this.nif = usu.nif;
        this.telefono = usu.telefono;
        this.email = usu.email;
    }
    
    public long getId () {
        return id;
    }
    
    public void setId (long id) {
        this.id = id ;
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos () {
        return apellidos;
    }
    
    public void setApellidos (String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getNif () {
        return nif;
    }
    
    public void setNif (String nif) {
        this.nif = nif;
    }
    
    public String getTelefono () {
        return telefono;
    }
    
    public void setTelefono (String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", telefono=" + telefono + ", email=" + email + '}';
    }
}
