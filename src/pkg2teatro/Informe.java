/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

import java.sql.Date;
public class Informe {
    
    private long id;
    public Date mesyaño;
    public double importe;
    
    public Informe(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getMesyaño() {
        return mesyaño;
    }

    public void setMesyaño(Date mesyaño) {
        this.mesyaño = mesyaño;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
    
}
