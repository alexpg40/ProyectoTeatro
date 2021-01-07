package Entidades;
//Guillermo Illera Vinatea

import java.util.ArrayList;
import java.util.Date;
import javafx.scene.input.KeyCode;

public class Franquicia {
    private long ID;
    private Date fecha_creacion;
    private String ubicacion;
    private boolean accesibilidad_reducida;
    // Se guarda el Grupo de trabajo que está trabajando en la franquicia
    private GTrabajo grupotrabajo;
    // Se guarda una lista de los empleados de la franquicia
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    // Se guarda el informe mensual de la franquicia
    private Informe informe;

    public Franquicia(){};
    
    public Franquicia (Franquicia f){
        this.ID = f.ID;
        this.fecha_creacion = f.fecha_creacion;
        this.ubicacion = f.ubicacion;
        this.accesibilidad_reducida = f.accesibilidad_reducida;
        this.informe = f.informe;
        this.empleados = f.empleados;
        this.grupotrabajo = f.grupotrabajo;
    };
    
    public Franquicia(long ID, Date fecha_creacion, String ubicacion, boolean accesibilidad_reducida, Informe informe, ArrayList<Empleado> empleados, GTrabajo grupotrabajo) {
        this.ID = ID;
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

    public long getID() {
        return ID;
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

    public void setID(long ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Franquicia{" + "ID=" + ID + ", fecha_creacion=" + fecha_creacion + ", ubicacion=" + ubicacion + ", accesibilidad_reducida=" + accesibilidad_reducida + ", grupotrabajo=" + grupotrabajo + ", empleados=" + empleados + ", informe=" + informe + '}';
    }

   
    
    
}
