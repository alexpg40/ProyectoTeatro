/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.Bono;
import java.util.ArrayList;

/**
 *
 * @author Sandr
 */
public class Usuario {
    private long id;
    // Valores válidos: Números > 0 | Valores invalidos: <=0 | Otras restricciones: No se puede repetir y solo puede ser entero.
    private String nombre;
    // Valores validos: cualquier letra | Valores invalidos: números, vakir vacío y null.
    private String apellidos;
    // Valores validos: cualquier letra | Valores invalidos: números, vakir vacío y null.
    private String nif;
    // Valores válidos: Tiene que haber 8 números y una letra | Valores inválidos: Vacío o null.
    private String telefono;
    // Valores válidos: Cualquier numero entero | Valores inválidos: | Otras restricciones: No puede repetirse y solo pueden haber números enteros.
    private String email;   
    // Valores válidos: Cualquier carácter | Valores inválidos: Carácteres especiales exceptuando la arroba (@) | Otras restricciones: Tiene que contener una arroba(@).
    // Los usuarios pueden tener muchos bonos
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
