package Entidades;
//Guillermo Illera Vinatea

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Informe {

    private long id;
    /*
        valores válidos: números > 0
        valores inválidos: números < 0
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
        valores inválidos: cualquier carácter diferente a un número, vacío y null.
     */
    private Secretariado secretario;
    // Se guarda una lista de los beneficios
    private ArrayList<Beneficio> beneficios = new ArrayList<>();
    // Se guarda una lista de los costes
    private ArrayList<Coste> costes = new ArrayList<>();

    public Informe() {
    }

    ;
    
    public Informe(Informe inf) {
        this.id = inf.id;
        this.mesyano = inf.mesyano;
        this.balance = inf.balance;
        this.secretario = inf.secretario;
        this.beneficios = inf.beneficios;
    }

    ;

    public Informe(long id, Date mesyano, double balance, Secretariado secretario, ArrayList<Beneficio> beneficios, ArrayList<Coste> costes) {
        this.id = id;
        this.mesyano = mesyano;
        this.balance = balance;
        this.secretario = secretario;
        this.beneficios = beneficios;
        this.costes = costes;
    }

    Informe(int i, Date fecha10, double d, Secretariado secretariado, ArrayList<Beneficio> beneficios, Coste costes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void generarId() {
        this.id = Utilidades.INFORMES.length + 1;
    }

    public Date dameFecha() {
        Scanner in = new Scanner(System.in);
        System.out.println("Dame el año:");
        int year = in.nextInt();
        System.out.println("Dame el mes:");
        int month = in.nextInt();
        System.out.println("Dame el día:");
        int day = in.nextInt();
        Date date = new GregorianCalendar(year, month, day).getTime();
        System.out.println("La fecha introducida es:" + date);
        return date;
    }

    ;
     
     
    public Informe nuevoInforme() {
        Informe inf = new Informe();
        Scanner sc = new Scanner(System.in);
        inf.generarId();
        System.out.println("Introduce el balance");
        double bal;
        sc = new Scanner(System.in);
        bal = sc.nextDouble();
        inf.setBalance(bal);
        inf.dameFecha();
        return inf;
    }

    @Override
    public String toString() {
        return "Informe{" + "id=" + id + ", mesyano=" + mesyano + ", balance=" + balance + ", secretario=" + secretario + ", beneficios=" + beneficios + ", costes=" + costes + '}';
    }

}
