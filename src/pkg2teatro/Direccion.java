/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

/**
 *
 * @author DarkB
 */
public class Direccion extends EmpleadoDeOficina{
    
    private int añosenelcargo;
    
    public Direccion(){
        
    }

    public int getAñosenplantilla() {
        return añosenplantilla;
    }

    public void setAñosenplantilla(int añosenplantilla) {
        this.añosenplantilla = añosenplantilla;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public int getAñosenelcargo(){
        return añosenelcargo;
    }

    public void setAñosenelcargo(int añosenelcargo){
        this.añosenelcargo = añosenelcargo;
    }
}
