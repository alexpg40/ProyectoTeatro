package Entidades;
//Guillermo Illera Vinatea

import java.util.ArrayList;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Informe {

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
        return balance;
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
     * @return date (fecha)
     */
    public Date dameFecha() {

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
    };
    
    /**
     * Función que realiza un nuevoInforme, con el id, el balance y la fecha.
     * @return nuevoInforme
     */
    public static Informe nuevoInforme() {
        Informe inf = new Informe();
        Scanner sc = new Scanner(System.in);
        inf.setId(nextIdInforme());
        System.out.println("Introduce el balance");
        double bal;
        sc = new Scanner(System.in);
        bal = sc.nextDouble();
        inf.setBalance(bal);
        inf.dameFecha();
        return inf;
    }
    /**
     * Función que crea un nuevo id basándose en el último que tengamos en la BD.
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

    @Override
    public String toString() {
        String ret = "Informe{\n" + "id=" + id + "\nmesyano=" + mesyano + "\nbalance=" + balance + "\nsecretario=" + secretario + "\nbeneficios=";
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
     * Función para ver los informes.
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
     * @param array
     * @return Arraylist<Informe>
     */
    
    public static ArrayList<Informe> convertirInforme(Informe[] array) {
        ArrayList<Informe> ret = new ArrayList<>();
        for (Informe inf : array) {
            ret.add((Informe)inf);
        }
        return ret;
    }
}
