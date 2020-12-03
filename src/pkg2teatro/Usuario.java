/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

/**
 *
 * @author Sandr
 */
public class Usuario {
    private long id;
    private String nombre;
    private String apellidos;
    private String NIF;
    private String telefono;
    private String email;    
    
    
    public Usuario () {
        
    }
    
    public Usuario (long id, String nombre, String apellidos, String NIF, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.telefono = telefono;
        this.email = email;
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
    
    public String getNIF () {
        return NIF;
    }
    
    public void setNIF (String NIF) {
        this.NIF = NIF;
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
}
