/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Sandr
 */
public class Beneficio {

    private long id;
    /*
        valores válidos: número > 0
        valores inválidos: número < 0
        otras restricciones: no puede repetirse, solo puede ser entero
     */
    private Date fecha;
    /*
        valores válidos: dd/mm/yyyy, todos números enteros, dd entre 1 y 31, dependiendo el mes 30 dias, mm entre 1 y 12, yyyy > 1000 y yyyy < 3000 
        valores inválidos: Números negativos y reales, y dd = 0 y > 31, mm > 12 o mm = 0, y yyyy < 1000 o yyyy > 3000. 
        Valor por defecto: Fecha actual. 
     */
    private double importe;
    /*
        valores válidos: Cualquier número > 0
        valores inválidos: Numero <= 0, cualquier carácter distinto, vacío y null.
     */
    private double reporte;
    /*
        valores válidos: cualquier número
        valores inválidos: cualquier carácter distinto a un número
     */
    
    // Los taquilleros reportan Beneficios.
    private Taquillero taquillero;

    public Beneficio() {

    }

    public Beneficio(long id, Date fecha, double importe, double reporte, Taquillero taquillero) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.reporte = reporte;
        this.taquillero = taquillero;
    }

    public Beneficio(Beneficio bn) {
        this.id = bn.id;
        this.fecha = bn.fecha;
        this.importe = bn.importe;
        this.reporte = bn.reporte;
        this.taquillero = bn.taquillero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getReporte() {
        return reporte;
    }

    public void setReporte(double reporte) {
        this.reporte = reporte;
    }
    
    public Taquillero getTaquillero(){
    return taquillero;
    }
    
    public void setTaquillero (Taquillero taquillero) {
        this.taquillero = taquillero;
    }
    
    /**
     * Función que nos da el siguiente id de un beneficio.
     * @return idBen
     */
    public long nextIdBeneficio() {
        long idBen = 0;
        for (int i = 0; i< Utilidades.BENEFICIOS.length; i++){
            if(Utilidades.BENEFICIOS[i].id > idBen)
                idBen = Utilidades.BENEFICIOS[i].id;
        }
        return idBen +1;
    }
            
    public void validarImporte(double importe) {

        if (importe < 0) {
            System.out.println("No puede ser menor que 0.");
        } else {
            this.importe = importe;
        }

    };
    /**
     * Función que pide fecha al usuario.
     * @param dt
     * @return date
     */
     public Date dameFecha(Date dt) {
        Scanner in = new Scanner(System.in);
        System.out.println("Dame el año:");
        int year = in.nextInt();
        System.out.println("Dame el mes:");
        int month = in.nextInt();
        System.out.println("Dame el día:");
        int day = in.nextInt();
        Date date = (Date) new GregorianCalendar(year, month, day).getTime();
        System.out.println("La fecha introducida es:" + date);
        return date;
    };
    /**
     * Función que crea un nuevo Beneficio.
     * @return b
     */
    public Beneficio nuevoBeneficio() {
        Beneficio b = new Beneficio();
        Scanner sc = new Scanner(System.in);
        b.setId(nextIdBeneficio());
        System.out.println("Introduce el importe");
        double imp;
        do {
            sc = new Scanner(System.in);
            imp = sc.nextDouble();
            b.setImporte(imp);
        } while (b.getImporte() != imp);
        System.out.println("Introduce el reporte");
        double rep;
        sc = new Scanner(System.in);
        rep = sc.nextDouble();
        b.setReporte(rep);
        Date date = (Date) new GregorianCalendar().getTime();
        sc = new Scanner(System.in);
        b.dameFecha(date);
        return b;
    }

    @Override
    public String toString() {
        return "Beneficio{" + "\nId=" + id + "\nFecha=" + fecha + "\nImporte=" + importe + "\nReporte=" + reporte + "\nTaquillero=" + taquillero + '}';
    }
}
