/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sandr
 */
public class Direccion extends EmpleadoDeOficina {
    private int añosPlantillaD;
    
    
    public int getAñosPlantillaD () {
        return añosPlantillaD;
    }
    
    public void setAñosPlantillaD (int añosPlantillaD) {
        this.añosPlantillaD = añosPlantillaD;
    }
    
    public Direccion (){
        super();
    }
    
    public Direccion (long id, String nombre, String apellidos, String nif, String direccion, String telefono, int añosPlantillaD){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.añosPlantillaD = añosPlantillaD;
    }
    
    public Direccion (Empleado e, int añosPlantilla){
        super(e, añosPlantilla);
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", años en plantilla" + añosPlantillaD +'}';
    }
}
