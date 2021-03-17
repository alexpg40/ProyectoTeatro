package Entidades;
//Guillermo Illera Vinatea

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Informe implements Serializable{

    private long id;
    /*
        valores válidos: números > 0
        valores inválidos: números <= 0
        otras restricciones: No puede repetirse, solo puede ser entero.
    
     */
    private Date mesyano;
    /*
        valores válidos: dd/mm/yyyy, todos números enteros, dd entre 1 y 31, dependiendo el mes 30 dias, mm entre 1 y 12, yyyy > 1000 y yyyy < 3000 
        valores inválidos: Números negativos y reales, y dd = 0 y > 31, mm > 12 o mm = 0, y yyyy < 1000 o yyyy > 3000. 
        valor por defecto: Fecha actual. 
     */
    private double balance;
    // Se guarda el Secretario que realiza el informe
    /*
        valores válidos: cualquier número
     */

    // Los empleados de secretariado realizan los informes
    private Secretariado secretario;
    // Se guarda una lista de los beneficios
    private ArrayList<Beneficio> beneficios = new ArrayList<>();
    // Se guarda una lista de los costes
    private ArrayList<Coste> costes = new ArrayList<>();
    private long idsecretariado;

    public void setIdSecretariado(long idsecretariado) {
        this.idsecretariado = idsecretariado;
    }

    public long getIdSecretariado() {
        return idsecretariado;
    }

    public Informe() {
    }

    public Informe(Informe inf) {
        this.id = inf.id;
        this.mesyano = inf.mesyano;
        this.balance = inf.balance;
        this.secretario = inf.secretario;
        this.beneficios = inf.beneficios;
        this.costes = inf.costes;
    }

    public Informe(long id, Date mesyano, double balance, Secretariado secretario, ArrayList<Beneficio> beneficios, ArrayList<Coste> costes) {
        this.id = id;
        this.mesyano = mesyano;
        this.balance = balance;
        this.secretario = secretario;
        this.beneficios = beneficios;
        this.costes = costes;
    }

    public long getId() {
        return id;
    }

    public Date getMesyano() {
        return mesyano;
    }

    public double getBalance() {
        double ret = 0.0;
        for (Beneficio ben : this.beneficios) {
            ret += ben.getImporte();
        }
//       for (Coste cos: this.costes){
//           ret -= cos.getImporte();
//       }
        for (int i = 0; i < this.costes.size(); i++) {
            Coste cos = this.costes.get(i);
            ret -= cos.getImporte();
        }
//        int i = 0;
//        Coste cos = new Coste();
//        while (i < this.costes.size()){
//            cos = this.costes.get(i);
//            ret -= cos.getImporte();
//            i++;
//        }
        return ret;
    }

    public Secretariado getSecretario() {
        return secretario;
    }

    public ArrayList<Beneficio> getBeneficios() {
        return beneficios;
    }

    public ArrayList<Coste> getCostes() {
        return costes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMesyano(Date mesyano) {
        this.mesyano = mesyano;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSecretario(Secretariado secretario) {
        this.secretario = secretario;
    }

    public void setBeneficios(ArrayList<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public void setCostes(ArrayList<Coste> costes) {
        this.costes = costes;
    }

    /**
     * Función que pide al usuario una fecha mediante el año, el mes y el día.
     *
     * @return date (fecha)
     */
    public static Date dameFecha() {

        Scanner in = new Scanner(System.in);

        System.out.println("Dame el año:");
        int year = in.nextInt();
        System.out.println("Dame el mes:");
        int month = in.nextInt();
        System.out.println("Dame el día:");
        int day = in.nextInt();
        Date date = new Date(year, month, day);

        System.out.println("La fecha introducida es:" + date);
        return date;
    }

    ;
    
    /**
     * Función que realiza un nuevoInforme, con el id, el balance y la fecha.
     * @return nuevoInforme
     */
    public static Informe nuevoInforme() {
        Informe inf = new Informe();
        Scanner sc = new Scanner(System.in);
        inf.setId(nextIdInforme());
        inf.setBalance(inf.getBalance());
        inf.setMesyano(Utilidades.dameFecha());
        inf.setSecretario(inf.getSecretario());
        return inf;
    }

    /**
     * Función que crea un nuevo id basándose en el último que tengamos en la
     * BD.
     *
     * @return nuevo id
     */
    public static long nextIdInforme() {
        long idInf = 0;
        for (int i = 0; i < Utilidades.INFORMES.length; i++) {
            if (Utilidades.INFORMES[i].id > idInf) {
                idInf = Utilidades.INFORMES[i].id;
            }
        }
        return idInf + 1;
    }

    /**
     * Función que valida el balance
     *
     * @param balance
     * @return boolean
     */
    public boolean validarBalance(double balance) {
        if (balance < 0) {
            System.out.println("El balance no puede ser menor de 0");
        } else {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String ret = "Los datos del informe son: \n" + "id=" + id + "\nmesyano=" + mesyano + "\nbalance=" + balance + "\nsecretario=" + secretario + "\nbeneficios=";
        for (Beneficio ben : beneficios) {
            ret += "Importe:" + ben.getImporte() + "\n";
            ret += "Reporte:" + ben.getReporte() + "\n";
        }
        ret += "\ncostes=";
        for (Coste cos : costes) {
            ret += "Importe:" + cos.getImporte();
        }
        ret += '}';
        return ret;
    }

    /**
     * Función que nos permite ver los Informes.
     *
     * @param array
     */
    public static void verInformes(ArrayList<Informe> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }

    /**
     * Función que convierte un array de Informes en un ArrayList de Informes
     * con los mismos elementos.
     *
     * @param array
     * @return Arraylist<Informe>
     */
    public static ArrayList<Informe> convertirInforme(Informe[] array) {
        ArrayList<Informe> ret = new ArrayList<>();
        for (Informe inf : array) {
            ret.add((Informe) inf);
        }
        return ret;
    }

    /**
     * Metodo para exportar los informes fichero de texto
     *
     * @return un string que se escribe en el fichero
     */
    public String data() {
        return this.id + "|" + this.balance + "|" + this.beneficios + "|" + this.costes + "|" + this.mesyano + "|" + this.secretario;
    }

    /**
     * Función que crea un archivo de texto donde con el metodo data se escriben
     * en cada linea cada empleado del array
     *
     * @param informes a escribir en el fichero
     */
    public static void guardarInformes(ArrayList<Informe> informes) {
        try {
            BufferedWriter bw = null;
            File f = new File("informes.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (Informe inf : informes) {
                        bw.write(inf.data());
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error");
                } finally {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("Error");
                    }
                }
                System.out.println("Se ha creado el archivo con los informes");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Función que guarda empleados en binario
     *
     * @param informes
     */
    public static void guardarinformesBinario(ArrayList<Informe> informes) {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("informesbinario.txt");
            out = new ObjectOutputStream(os);
            for (Informe inf : informes) {
                out.writeObject(inf);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el OutputStream");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el OutputStream");
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar ObjectOutputStream");
                }
            }
        }
        System.out.println("Se ha creado el archivo con los informes binarios!");
    }

    /**
     * Guarda un único informe en un fichero binario
     */
    public void guardarInformeBinario() {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("informebinario.txt");
            out = new ObjectOutputStream(os);
            out.writeObject(this);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");;
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el OutputStream");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectOutputStream");
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el OutputStream");
                }
            }
        }
    }

    /**
     * Lee un objeto informe del archivo binario donde se guarda el anterior
     * metodo
     */
    public static void leerObjetoBinarioEmpleado() {
        InputStream is = null;
        ObjectInput in = null;
        try {
            is = new FileInputStream("informebinario.txt");
            in = new ObjectInputStream(is);
            Empleado e = (Empleado) in.readObject();
            System.out.println(e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Fallo al convertir el objeto a jugador");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
        }
    }

    /**
     * Lee el archivo binario donde se guardan los informes
     */
    public static void leerFicheroBinarioInformes() {
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream("informesbinario.txt");
            oi = new ObjectInputStream(is);
            while (is.available() > 0) {
                Informe inf = (Informe) oi.readObject();
                System.out.println(inf.toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el ObjectInputStream");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                }
            }
        }
    }

    /**
     * Guarda un objeto de tipo informe en el fichero de texto ya creado
     * "informes.txt", sin borrar los anteriores
     */
    public void guardarInforme() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("informes.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");

        } catch (IOException ex) {
            Logger.getLogger(Empleado.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileWriter");
                }
            }
        }
    }

    /**
     * Importa los informes guardados en un fichero guardado en el parametro
     * ruta
     *
     * @param ruta string de la ruta
     * @return un arraylist con los informes importados
     */
    public static ArrayList<Informe> importarInformesBinarios(String ruta) {
        ArrayList<Informe> ret = new ArrayList<>();
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream(ruta);
            oi = new ObjectInputStream(is);
            while (is.available() > 0) {
                Informe inf = (Informe) oi.readObject();
                System.out.println("Se ha importado con exito el informe: ");
                System.out.println(inf.data());
                ret.add(inf);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Se ha dado una IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                }
            }
        }
        return ret;
    }

    /**
     * Importa los informes de un fichero de texto de un ruta que has de pasar
     * como parametro
     *
     * @param ubi string con la ruta
     * @return arraylist de empleados importados
     */
    public static ArrayList<Informe> importarInformes(String ubi) {
        ArrayList<Informe> ret = new ArrayList<>();
        Informe inf;
        String texto;
        File f = new File(ubi);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    inf = new Informe();
                    String[] array = texto.split("\\|");
                    inf.setId(Long.valueOf(array[0]));
                    inf.setMesyano(Date.valueOf(array[1]));
                    inf.setBalance(Double.parseDouble(array[2]));
                    inf.setIdSecretariado(Long.parseLong(array[3]));
                    //   inf.setBeneficios(array[4]);
                    //   inf.setCostes(array[5]);
                    ret.add(inf);
                }
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el BufferedReader");
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileReader");
                }
            }
        }
        return ret;
    }

    /**
     * Busca en el archivo de texto un informe con la id introducida
     *
     * @param id a buscar
     * @return informe con la misma id que la introducida
     */
    public static Informe getInformeByIDFichero(long id) {
        Informe inf = new Informe();
        String texto;
        File f = new File("informes.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    if (Long.valueOf(array[0]) == id) {
                        inf.setId(Long.valueOf(array[0]));
                        inf.setMesyano(Date.valueOf(array[1]));
                        inf.setBalance(Double.parseDouble(array[2]));
                        inf.setIdSecretariado(Long.parseLong(array[3]));
                        //   inf.setBeneficios(array[4]);
                        //   inf.setCostes(array[5]);
                        System.out.println(inf);
                        return inf;
                    }
                }
                System.out.println("No existe el empleado con el id introducido.");
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido encontrar el archivo");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el BufferedReader");
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileReader");
                }
            }
        }
        return inf;
    }
}
