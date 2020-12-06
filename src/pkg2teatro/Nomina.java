package pkg2teatro;

import java.util.Date;

public class Nomina {
    private long id;
    private Date mesyano;
    private Coste coste;
    private Direccion direccion;
    private Secretariado secretariado;

    public Nomina (){};
    
    public Nomina (Nomina nom) {
        this.id = nom.id;
        this.mesyano = nom.mesyano;
        this.coste = nom.coste;
        this.direccion = nom.direccion;
        this.secretariado = nom.secretariado;
    };
    
    public Nomina(long id, Date mesyano, Coste coste, Direccion direccion, Secretariado secretariado) {
        this.id = id;
        this.mesyano = mesyano;
        this.coste = coste;
        this.direccion = direccion;
        this.secretariado = secretariado;
    }

    public long getId() {
        return id;
    }

    public Date getMesyano() {
        return mesyano;
    }

    public Coste getCoste() {
        return coste;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Secretariado getSecretariado() {
        return secretariado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMesyaño(Date mesyano) {
        this.mesyano = mesyano;
    }

    public void setCoste(Coste coste) {
        this.coste = coste;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setSecretariado(Secretariado secretariado) {
        this.secretariado = secretariado;
    }

    @Override
    public String toString() {
        return "Nomina{" + "id=" + id + ", mesya\u00f1o=" + mesyano + ", coste=" + coste + ", direccion=" + direccion + ", secretariado=" + secretariado + '}';
    }
    
    
}
