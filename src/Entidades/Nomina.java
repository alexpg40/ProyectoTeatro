package Entidades;

import java.sql.Date;

public class Nomina {
    private long id;
    // Valores válidos: Números > 0 | Valores inválidos: Números <=0 | Otras restricciones: No puede repetirse, solo puede ser entero. 
    private Date mesyano;
    // Valores válidos: dd/mm/yyyy, todos los números serán enteros, dd entre 1 y 31, dependiendo el mes 30 dias, mm entre 1 y 12, yyyy > 1000 y yyyy < 3000 
    // Valores inválidos: Números negativos y reales, y dd = 0 y > 31, mm > 12 o mm = 0, y yyyy < 1000 o yyyy > 3000. | Valor por defecto: Fecha actual.

    public Nomina (){};
    
    public Nomina (Nomina nom) {
        this.id = nom.id;
        this.mesyano = nom.mesyano;
    };
    
    public Nomina(long id, Date mesyano) {
        this.id = id;
        this.mesyano = mesyano;
    }

    public long getId() {
        return id;
    }

    public Date getMesyano() {
        return mesyano;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMesyaño(Date mesyano) {
        this.mesyano = mesyano;
    }

    public void generarId(){
       this.id = Utilidades.NOMINAS.length + 1;
    }
    
    public Nomina nuevaNomina (){
        Nomina n = new Nomina();
        n.generarId();
        System.out.println("Se ha generado la ID: " + n.getId());
        return n;
    };
    
    @Override
    public String toString() {
        return "Nomina{" + "id=" + id + ", mesya\u00f1o=" + mesyano + '}';
    }    
}