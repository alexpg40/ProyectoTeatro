/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author Sandr
 */
public class Direccion extends EmpleadoDeOficina {
    private int añosPlantillaD;
    /*
        valores válidos: entero > 0
        valores inválidos: entero < 0, cualquier carácter que no sea entero, null y vacío.
    */
    
    
    public int getAñosPlantillaD () {
        return añosPlantillaD;
    }
    
    public void setAñosPlantillaD (int añosPlantillaD) {
        this.añosPlantillaD = añosPlantillaD;
    }
    
    public Direccion (){
        super();
    }
    
    public Direccion (long id, String nombre, String apellidos, String nif, String direccion, String telefono, int añosPlantillaD){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.añosPlantillaD = añosPlantillaD;
    }
    
    public Direccion (Empleado e, int añosPlantilla){
        super(e, añosPlantilla);
    }
    
    
    public void comprobarAñosplantillaD(int añosPlantillaD){
        if (!(añosPlantillaD >= 0 && añosPlantillaD <80)) {
            System.out.println("Los años en plantilla tiene que estar entre 0 y 80");
        } else{
            this.añosPlantillaD = añosPlantillaD;
        }
    }
    
     public Direccion nuevaDireccion(){
        Direccion direc = new Direccion();
        Scanner sc = new Scanner(System.in);
        direc.getId();
        System.out.println("Introduce el id");
        long id;
        do {
            sc = new Scanner(System.in);
            id = sc.nextLong();
            direc.setId(id);
        } while (direc.getId() != id);
        return direc;
     }
     
     
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", años en plantilla" + añosPlantillaD +'}';
    }
}
