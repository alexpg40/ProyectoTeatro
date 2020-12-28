/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Sandr
 */
public class Bono {
    private long id;
    private char tipo;
    private int mes;
    private Usuario usuario;
    
    
    public Bono () {
        
    }
    
    public Bono (long id, char tipo, int mes) {
        this.id = id;
        this.tipo = tipo;
        this.mes = mes;
    }
    
     public Bono (Bono bono){
        this.id = bono.id;
        this.tipo = bono.tipo;
        this.mes = bono.mes;
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
    
    public Usuario getUsuario () {
        return usuario;
    }
    
    public void setUsuario (Usuario usuario){
        this.usuario = usuario;
    }
     @Override
    public String toString() {
        return "Bono{" + "id=" + id + ", tipo=" + tipo + ", mes=" + mes + ", usuario=" + usuario + '}';
    }
}
