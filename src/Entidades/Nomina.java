package Entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

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

    public void setMesyano(Date mesyano) {
        this.mesyano = mesyano;
    }

    public void generarId(){
       this.id = Utilidades.NOMINAS.length + 1;
    }
    
    public Nomina nuevaNomina (){
        Nomina n = new Nomina();
        n.generarId();
        System.out.println("Se ha generado la ID: " + n.getId());
        n.setMesyano(Utilidades.dameFecha());
        return n;
    };
    
    @Override
    public String toString() {
        return "Nomina{" + "id=" + id + ", mesya\u00f1o=" + mesyano + '}';
    }    
    
        
     /**
     *  Metodo para exportar los bonos.
     * @return Un string que se añade al fichero exportado
     */
 
    public String data() {
        return this.id + "|" + this.mesyano;
    }

    /**
     * Crea un archivo de texto donde con el metodo data se escriben en cada linea cada empleado del array 
     * @param costes a escribir en el fichero
     */
    public static void guardarNomina(ArrayList<Nomina> nominas) {
        try {
            BufferedWriter bw = null;
            File f = new File("costes.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (Nomina n: nominas) {
                        bw.write(n.data());
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
    
    public static ArrayList<Nomina> convertirNominas(Nomina[] array) {
        ArrayList<Nomina> ret = new ArrayList<>();
        for (Nomina nominas : array) {
            ret.add((Nomina)nominas);
        }
        return ret;
    }
}