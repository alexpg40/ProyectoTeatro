/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Sandr
 */
public class Secretariado extends EmpleadoDeOficina {
    
    //El secretariado elabora distintas nóminas
    private ArrayList<Nomina> nominas = new ArrayList<>();
    
    public Secretariado (long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
   }
       
       
    public Secretariado (){
        super();
    }
    
    public Secretariado(Empleado e){
        super(e);
    }
    
    public Secretariado (Empleado e, int añosPlantilla){
        super(e, añosPlantilla);
    }
    
    public ArrayList<Nomina> getNomina() {
        return nominas;
    }
    
    public void setBeneficio(ArrayList<Beneficio> beneficios) {
        this.nominas = nominas;
    } 
    
    public static Secretariado nuevoSecretariado(ArrayList<Empleado> empleados){
        EmpleadoDeOficina e = EmpleadoDeOficina.nuevoEmpleadoDeOficina(empleados);
        Secretariado s = new Secretariado(e);
    return s;}
    
    @Override
    public String toString() {
        return this.id + ". " + this.nombre + " " + this.apellidos + " Nif: " + this.nif + " Telefono: " + this.telefono + " (" + this.getClass().getSimpleName() + ")";
    }
} 
