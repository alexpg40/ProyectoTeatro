package pkg2teatro;
// Guillermo Illera Vinatea

import java.util.Date;

public class Nomina {
    private long id;
    private Date mesyano;

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


    @Override
    public String toString() {
        return "Nomina{" + "id=" + id + ", mesya\u00f1o=" + mesyano + '}';
    }
    
    
}
