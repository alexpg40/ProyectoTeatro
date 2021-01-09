package Entidades;

import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;


public class Coste {
    private long id;
    // Valores válidos: Números > 0 | Valores inválidos: Números <=0 | Otras restricciones: No puede repetirse, solo puede ser entero. 
    private Date fecha;
    // Valores válidos: dd/mm/yyyy, todos
    // Números enteros, dd entre 1 y 31, dependiendo el mes 30 dias, mm entre 1 y 12, yyyy > 1000 y yyyy < 3000 
    // Valores inválidos: Números negativos y reales, y dd = 0 y > 31, mm > 12 o mm = 0, y yyyy < 1000 o yyyy > 3000. | Valor por defecto: Fecha actual.
    // Se guarda el acomododador que reporta el coste
    private double importe;
    // Valores válidos: Cualquier número > 0 | Valores inválidos: Numero <=0, cualquier carácter distinto, vacío y null.
    private Acomodador acomodador;
   
    // Se guarda el limpiador que reporta el coste
    private Limpieza limpieza;
    // Se guarda la nómina que genera el coste
    private Nomina nomina;
    // Se guarda el informe en el que va el coste
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
    
    public Coste(long id, Date fecha, double importe, Acomodador acomodador, Nomina nomina, Informe informe) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.acomodador = acomodador;
        this.nomina = nomina;
        this.informe = informe;
    }

    public Coste(long id, Date fecha, double importe, Limpieza limpieza, Nomina nomina, Informe informe) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.limpieza = limpieza;
        this.nomina = nomina;
        this.informe = informe;
    }

    Coste(int i, LocalDate now, int i0, double d, Acomodador acomodador, Limpieza limpieza, int i1, Informe informe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Coste(int i, java.util.Date fecha10, int i0, double d, Acomodador acomodador, Limpieza limpieza, int i1, Informe informe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Coste(int i, java.util.Date fecha11, int i0, Limpieza limpieza, int i1, Informe informe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public void comprobarId(long id){
        boolean condicion = false;
            if (id < 0 || id == 0) {
            System.out.println("La ID debe de ser mayor estricto de 0.");
        } else {
            for (Coste Coste : Utilidades.COSTES){
                if (id == Coste.getId()){
                    condicion = true;
                    break;
                } else {
                    condicion = false;
                }
            }
        if (condicion) {
            System.out.println("La ID ya está registrada.");
        } else {
            this.id = id;
        }
        }
    }
    
    
    public void comprobarImporte (double importe){
                
        if (importe < 0) {
            System.out.println("No puede ser menor que 0.");
        } else {
            this.importe = importe;
        }
        
    };
    
    public Coste nuevoCoste(){
        Coste c = new Coste();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el ID: ");
        long ident;
        
        do {
            ident = -1;
            in = new Scanner(System.in);
            ident = in.nextLong();
            c.comprobarId(ident);
        } while(c.getId() != ident || ident == 0);
        
        System.out.println("Introduzca ahora el importe: ");
        
        long imp;
        do {
            imp = -1;
            in = new Scanner(System.in);
            imp = in.nextLong();
            c.comprobarImporte(imp);
        } while (c.getImporte() != imp || imp <0);
        return c;
    };
    
    @Override
    public String toString() {
        return "Coste{" + "id=" + id + ", fecha=" + fecha + ", importe=" + importe + ", acomodador=" + acomodador + ", limpieza=" + limpieza + ", nomina=" + nomina + ", informe=" + informe + '}';
    }
    
    
}