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
public class Direccion extends EmpleadoDeOficina {
    private int añosCargo;
    
    
    public int getAñosCargo () {
        return añosCargo;
    }
    
    public void setAñosCargo (int añosCargo) {
        this.añosCargo = añosCargo;
    }
    
    public Direccion (){
        super();
    }
    
}
