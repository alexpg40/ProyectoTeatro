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
class EmpleadoDeOficina extends Empleado{
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
}
