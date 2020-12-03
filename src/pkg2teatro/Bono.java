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
public class Bono {
    private long id;
    private char tipo;
    private int mes;    
    
    public Bono () {
        
    }
    
    public Bono (long id, char tipo, int mes) {
        this.id = id;
        this.tipo = tipo;
        this.mes = mes;
    }
    
    public long getId () {
        return id;
    }
    
    public void setId (long id) {
        this.id = id;
    }
    
    public char getTipo () {
        return tipo;
    }
    
    public void setTipo (char tipo) {
        this.tipo = tipo;
    }
    
    public int getMes () {
        return mes;
    }
    
    public void setMes (int mes) {
        this.mes = mes;
    }
}
