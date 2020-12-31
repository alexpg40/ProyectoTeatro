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
public class EmpleadoDeOficina extends Empleado{
   protected int añosPlantilla;
    
    
    public EmpleadoDeOficina () {
        super();
    }
    
    public EmpleadoDeOficina (Empleado e, int añosPlantilla) {
        super(e);
        this.añosPlantilla = añosPlantilla;
    } 
    
    public EmpleadoDeOficina(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria){
        super.id = id;
        super.nombre = nombre;
        super.apellidos = apellidos;
        super.nif = nif;
        super.direccion = direccion;
        super.telefono = telefono;
    }

    public int getAñosPlantilla() {
        return añosPlantilla;
    }

    public void setAñosPlantilla(int añosPlantilla) {
        this.añosPlantilla = añosPlantilla;
    }
    
    public void comprobarAñosplantilla(int añosPlantilla){
        if (!(añosPlantilla >= 0 && añosPlantilla <80)) {
            System.out.println("Los años en plantilla tiene que estar entre 0 y 80");
        }
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", años en plantilla" + añosPlantilla +'}';
    }
}
