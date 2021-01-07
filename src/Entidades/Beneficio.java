/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author Sandr
 */
public class Beneficio {
    private long id;
    /*
        valores válidos: número > 0
        valores inválidos: número < 0
        otras restricciones: no puede repetirse, solo puede ser entero
    */ 
    private Date fecha;
    /*
        valores válidos: dd/mm/yyyy, todos números enteros, dd entre 1 y 31, dependiendo el mes 30 dias, mm entre 1 y 12, yyyy > 1000 y yyyy < 3000 
        valores inválidos: Números negativos y reales, y dd = 0 y > 31, mm > 12 o mm = 0, y yyyy < 1000 o yyyy > 3000. 
        Valor por defecto: Fecha actual. 
    */
    private double importe;
    /*
        valores válidos: Cualquier número > 0
        valores inválidos: Numero <= 0, cualquier carácter distinto, vacío y null.
    */
    private double reporte;
    /*
        valores válidos: cualquier número
        valores inválidos: cualquier carácter distinto a un número
    */
    private Taquillero taquillero;
    
    
    public Beneficio () {
        
    }
    
    public Beneficio (long id, Date fecha, double importe, double reporte, Taquillero taquillero) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.reporte = reporte;
        this.taquillero = taquillero;
    }
    
     public Beneficio (Beneficio bn){
        this.id = bn.id;
        this.fecha = bn.fecha;
        this.importe = bn.importe;
        this.reporte = bn.reporte;
    }

    Beneficio(int i, java.util.Date fecha19, double d, double d0, Taquillero taquillero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    public long getId () {
        return id;
    }
    
    public void setId (long id) {
        this.id = id;
    }
    
    public Date getFecha () {
        return fecha;
    }
    
    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }
    
    public double getImporte () {
        return importe;
    }
    
    public void setImporte (double importe) {
        this.importe = importe;
    }
    
    public double getReporte () {
        return reporte;
    }
    
    public void setReporte (double reporte) {
        this.reporte = reporte;
    }  
    
      @Override
    public String toString() {
        return "Beneficio{" + "id=" + id + ", fecha=" + fecha + ", importe=" + importe + ", reporte=" + reporte + ", taquillero=" + taquillero + '}';
    }
}
