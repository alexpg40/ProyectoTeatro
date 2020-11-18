/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

import java.util.Date;
public class Nomina {
    
    private long id;
    private Date mesyaño;
    
    public Nomina(){
        
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public Date getMesyaño(){
        return mesyaño;
    }
    
    public void setMesyaño(Date mesyaño){
        this.mesyaño = mesyaño;
    }
    
}
