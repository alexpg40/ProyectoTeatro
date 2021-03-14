package Entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
    
    public Coste (){};
    
    public Coste(Coste cos){
        this.id = cos.id;
        this.fecha = cos.fecha;
        this.importe = cos.importe;
        this.acomodador = cos.acomodador;
        this.limpieza = cos.limpieza;
        this.nomina = cos.nomina;
    };

    public Coste(long id, Date fecha, double importe, Acomodador acomodador, Limpieza limpieza, Nomina nomina) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.acomodador = acomodador;
        this.limpieza = limpieza;
        this.nomina = nomina;
    }
    
    public Coste(long id, Date fecha, double importe, Acomodador acomodador, Nomina nomina) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.acomodador = acomodador;
        this.nomina = nomina;
    }

    public Coste(long id, Date fecha, double importe, Limpieza limpieza, Nomina nomina) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.limpieza = limpieza;
        this.nomina = nomina;
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
    
    public void generarId(){
       this.id = Utilidades.COSTES.length + 1;
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
        c.generarId();
        c.setFecha(Utilidades.dameFecha());
        System.out.println("Introduzca el importe: ");
        
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
        return "Coste{" + "id=" + id + ", fecha=" + fecha + ", importe=" + importe + ", acomodador=" + acomodador + ", limpieza=" + limpieza + ", nomina=" + nomina + '}';
    }
    
     /**
     *  Metodo para exportar los bonos.
     * @return Un string que se añade al fichero exportado
     */
 
    public String data() {
        return this.id + "|" + this.acomodador + "|" + this.fecha + "|" + this.importe + "|" + this.limpieza + "|" + this.nomina;
    }

    /**
     * Crea un archivo de texto donde con el metodo data se escriben en cada linea cada empleado del array 
     * @param costes a escribir en el fichero
     */
    public static void guardarCoste(ArrayList<Coste> costes) {
        try {
            BufferedWriter bw = null;
            File f = new File("costes.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (Coste c: costes) {
                        bw.write(c.data());
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println(" Error de Entrada/Salida ");
                    e.getStackTrace();
                } finally {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("Error de Entrada/Salida ");
                        ex.getStackTrace();
                    }
                }
                System.out.println("Se ha creado el archivo con los bonos.");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static ArrayList<Coste> convertirCostes(Coste[] array) {
        ArrayList<Coste> ret = new ArrayList<>();
        for (Coste coste : array) {
            ret.add((Coste)coste);
        }
        return ret;
    }
}
