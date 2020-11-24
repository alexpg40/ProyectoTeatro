/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

import java.util.ArrayList;
public class Bono {
    
    public long ID;
    public int mes;
    public char tipo;
    
    public Bono(){
    } 
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public String toString(){
        String mensaje = "Este el bono con ID = " + ID;
        return mensaje;
    }
    
}
