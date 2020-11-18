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
import java.util.Date;
public class Franquicia {
    
    private long id;
    private Date fechadecreacion;
    private String ubicacion;
    private boolean accesibilidad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(Date fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }
    
    public Franquicia (){  
    }
    public Franquicia(long id, Date fechadecreacion, String ubicacion, boolean accesibilidad){
        this.id = id;
        this.fechadecreacion = fechadecreacion;
        this.ubicacion = ubicacion;
        this.accesibilidad = accesibilidad;
    }
}
 
