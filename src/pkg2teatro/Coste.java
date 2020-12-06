package pkg2teatro;

import java.util.Date;

public class Coste {
    private long id;
    private Date fecha;
    private double importe;
    private Acomodador acomodador;
    private Limpieza limpieza;
    private Nomina nomina;
    private Informe informe;
    
    public Coste (){};
    
    public Coste(Coste cos){
        this.id = cos.id;
        this.fecha = cos.fecha;
        this.importe = cos.importe;
        this.acomodador = cos.acomodador;
        this.limpieza = cos.limpieza;
        this.nomina = cos.nomina;
        this.informe = cos.informe;
    };

    public Coste(long id, Date fecha, double importe, Acomodador acomodador, Limpieza limpieza, Nomina nomina, Informe informe) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.acomodador = acomodador;
        this.limpieza = limpieza;
        this.nomina = nomina;
        this.informe = informe;
    }

    public long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public Acomodador getAcomodador() {
        return acomodador;
    }

    public Limpieza getLimpieza() {
        return limpieza;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setAcomodador(Acomodador acomodador) {
        this.acomodador = acomodador;
    }

    public void setLimpieza(Limpieza limpieza) {
        this.limpieza = limpieza;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    @Override
    public String toString() {
        return "Coste{" + "id=" + id + ", fecha=" + fecha + ", importe=" + importe + ", acomodador=" + acomodador + ", limpieza=" + limpieza + ", nomina=" + nomina + ", informe=" + informe + '}';
    }
    
    
}
