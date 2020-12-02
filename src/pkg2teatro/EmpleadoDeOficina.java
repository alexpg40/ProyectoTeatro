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
public class EmpleadoDeOficina extends Empleado{
    
    protected int añosenplantilla;

    public int getAñosenplantilla() {
        return añosenplantilla;
    }

    public void setAñosenplantilla(int añosenplantilla) {
        this.añosenplantilla = añosenplantilla;
    }
    
    public EmpleadoDeOficina(long id, String nombre, String apellidos, int añosenplantilla){
        super();
        this.añosenplantilla = añosenplantilla;
    } 
}
