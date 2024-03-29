package Entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bono {

    private long id;
    // Valores válidos: Números > 0| Valores inválidos: Números <=0 | Otras restricciones: No puede repetirse, solo enteros.
    private char tipo;
    // Valores válidos: "P" y "C" | Valores inválidos: Caracter diferente, null o vacío.| Otras restricciones: Parcial solo sirve para el fin de semana. (Los cojones voy a saber hacer yo esto)
    private int mes;
    // Valores válidos: Número entero entre 1 y 12.| Valores inválidos: Cualquier número o carácter distinto que no esté comprendido entre 1 y 12, null y vacío.
    private Usuario usuario;

    public Bono() {

    }

    public Bono(long id, char tipo, int mes) {
        this.id = id;
        this.tipo = tipo;
        this.mes = mes;
    }

    public Bono(Bono bono) {
        this.id = bono.id;
        this.tipo = bono.tipo;
        this.mes = bono.mes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void generarId() {
        this.id = Utilidades.BONOS.length + 1;
    }

    public void comprobarTipo(char tipo) {
        if (tipo != 'C' && tipo != 'P') {
            System.out.println("La categoria solo puede C (Completo) o P (Parcial)");
        } else {
            this.tipo = tipo;
        }
    }

    ;
    
    public void comprobarMes(int mes) {
        if (mes < 1) {
            System.out.println("No puede ser menor de 1.");
            nuevoBono();
        } else if (mes > 12) {
            System.out.println("No puede ser mayor de 12.");
        } else {
            this.mes = mes;
        };
    }

    ;
    
    public Bono nuevoBono() {
        Bono b = new Bono();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce la categoria");
        char tipo = 0;
        do {
            tipo = 0;
            in = new Scanner(System.in);
            tipo = in.next().charAt(tipo);
            b.comprobarTipo((char) tipo);
        } while (b.getTipo() != tipo);
        int m;
        do {
            in = new Scanner(System.in);
            m = in.nextInt();
            b.comprobarMes(m);
        } while (b.getMes() != m);
        b.guardarBono();
        return b;
    }

    ;
     @Override
    public String toString() {
        return "Bono{" + "id=" + id + ", tipo=" + tipo + ", mes=" + mes + ", usuario=" + usuario + '}';
    }
    
     /**
     *  Metodo para exportar los bonos.
     * @return Un string que se añade al fichero exportado
     */
 
    public String data() {
        return this.id + "|" + this.mes + "|" + this.tipo + "|" + this.usuario;
    }

    /**
     * Crea un archivo de texto donde con el metodo data se escriben en cada linea cada empleado del array 
     * @param bonos a escribir en el fichero
     */
    public static void guardarBonos(ArrayList<Bono> bonos) {
        try {
            BufferedWriter bw = null;
            File f = new File("bonos.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (Bono b : bonos) {
                        bw.write(b.data());
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
    
    public static ArrayList<Bono> convertirBonos(Bono[] array) {
        ArrayList<Bono> ret = new ArrayList<>();
        for (Bono bono : array) {
            ret.add((Bono)bono);
        }
        return ret;
    }
    
        public void guardarBono() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("bono.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();

        } catch (IOException ex) {
            ex.getStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                    ex.getStackTrace();
                }
            }
            if (fw != null) {
                try{
                    fw.close();
                } catch(IOException ex){
                    System.out.println("No se ha podido cerrar el FileWriter");
                    ex.getStackTrace();
                }
            }
        }

    }
}
