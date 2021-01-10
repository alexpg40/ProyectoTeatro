package Entidades;
//Guillermo Illera Vinatea

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.input.KeyCode;

public class Franquicia {
    private long id;
    /*  
        valores válidos: números > 0
        valores inválidos: números < 0
        otras restricciones: No puede repetirse, solo puede ser entero.
    */
    private Date fecha_creacion;
    /*
        Valores válidos: dd/mm/yyyy, todos números enteros, dd entre 1 y 31, dependiendo el mes 30 dias, mm entre 1 y 12, yyyy > 1000 y yyyy < 3000 
        Valores inválidos: Números negativos y reales, y dd = 0 y > 31, mm > 12 o mm = 0, y yyyy < 1000 o yyyy > 3000. 
        Valor por defecto: Fecha actual. 
    */
    private String ubicacion;
    /*
        valores válidos: Letras, números enteros.
        valores inválidos: Valor “ “ (vacio) o null.
    */
    private boolean accesibilidad_reducida;
    // Se guarda el Grupo de trabajo que está trabajando en la franquicia
    /*
        valores válidos: true/false
        valores inválidos: null
    */
    private GTrabajo grupotrabajo;
    // Se guarda una lista de los empleados de la franquicia
    private ArrayList<Empleado> empleados = new ArrayList<>();
    // Se guarda el informe mensual de la franquicia
    private Informe informe;

    public Franquicia(){};
    
    public Franquicia (Franquicia f){
        this.id = f.id;
        this.fecha_creacion = f.fecha_creacion;
        this.ubicacion = f.ubicacion;
        this.accesibilidad_reducida = f.accesibilidad_reducida;
        this.informe = f.informe;
        this.empleados = f.empleados;
        this.grupotrabajo = f.grupotrabajo;
    };
    
    public Franquicia(long id, Date fecha_creacion, String ubicacion, boolean accesibilidad_reducida, Informe informe, ArrayList<Empleado> empleados, GTrabajo grupotrabajo) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.ubicacion = ubicacion;
        this.accesibilidad_reducida = accesibilidad_reducida;
        this.informe = informe;
        this.grupotrabajo = grupotrabajo;
        this.empleados = empleados;
    }

    Franquicia(int i, Date fecha12, String barcelona_Llissá_de_Munt, KeyCode keyCode, Informe Informe, Empleado empleados, GTrabajo GTrabajo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        return id;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isAccesibilidad_reducida() {
        return accesibilidad_reducida;
    }

    public GTrabajo getGrupotrabajo() {
        return grupotrabajo;
    }

    
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setAccesibilidad_reducida(boolean accesibilidad_reducida) {
        this.accesibilidad_reducida = accesibilidad_reducida;
    }

    public void setGrupotrabajo(GTrabajo grupotrabajo) {
        this.grupotrabajo = grupotrabajo;
    }

    
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

     public void generarId(){
       this.id = Utilidades.FRANQUICIAS.length + 1;
    }   
    
    public void comprobarUbicacion(String ubicacion) {
        if (ubicacion.isEmpty()) {
            System.out.println("La ubicación no puede estar vacia");
        } else {
            this.ubicacion = ubicacion;
        }
    }
    
    
     public Franquicia nuevaFranquicia(){
        Franquicia f = new Franquicia();
        Scanner sc = new Scanner(System.in);
        f.getId();
        System.out.println("Introduce el id");
        long id;
        do {
            sc = new Scanner(System.in);
            id = sc.nextLong();
            f.setId(id);
        } while (f.getId() != id);
        System.out.println("Introduce la ubicación");
        String ubi;
        do {
            sc = new Scanner(System.in);
            ubi = sc.nextLine();
            f.comprobarUbicacion(ubi);
        } while (f.getUbicacion() != ubi);
        return f;
    }    
    
    @Override
    public String toString() {
        return "Franquicia{" + "id=" + id + ", fecha_creacion=" + fecha_creacion + ", ubicacion=" + ubicacion + ", accesibilidad_reducida=" + accesibilidad_reducida + ", grupotrabajo=" + grupotrabajo + ", empleados=" + empleados + ", informe=" + informe + '}';
    }

   
    
    
}
