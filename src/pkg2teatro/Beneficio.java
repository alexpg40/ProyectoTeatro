/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

import java.sql.Date;

/**
 *
 * @author Sandr
 */
public class Beneficio {
    private long id;
    private Date fecha;
    private double importe;
    private double reporte;
    // Se va a guardar el taquillero que genera el beneficio
    private Taquillero taquillero;
    
    
    public Beneficio () {
        
    }
    
    public Beneficio (long id, Date fecha, double importe, double reporte) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.reporte = reporte;
    }
    
     public Beneficio (Beneficio bn){
        this.id = bn.id;
        this.fecha = bn.fecha;
        this.importe = bn.importe;
        this.reporte = bn.reporte;
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
