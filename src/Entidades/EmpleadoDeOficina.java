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
public class EmpleadoDeOficina extends Empleado{
    
    //VALORES VALIDOS: ENTERO => 0 Y ENTERO <= 80 && VALORES INVALIDOS: ENTEROS > 80 o < 0, CUALQUIER CARACTER DIFERENTE A UN NUMERO 
   protected int añosPlantilla;
    
    
    public EmpleadoDeOficina () {
        super();
    }
    public EmpleadoDeOficina(Empleado e){
        super(e);
    }
    public EmpleadoDeOficina (Empleado e, int añosPlantilla) {
        super(e);
        this.añosPlantilla = añosPlantilla;
    } 
    
    public EmpleadoDeOficina(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria){
        super.id = id;
        super.nombre = nombre;
        super.apellidos = apellidos;
        super.nif = nif;
        super.direccion = direccion;
        super.telefono = telefono;
    }

    public int getAñosPlantilla() {
        return añosPlantilla;
    }

    public void setAñosPlantilla(int añosPlantilla) {
        this.añosPlantilla = añosPlantilla;
    }
    
    public void comprobarAñosplantilla(int añosPlantilla){
        if (!(añosPlantilla >= 0 && añosPlantilla <80)) {
            System.out.println("Los años en plantilla tiene que estar entre 0 y 80");
        } else{
            this.añosPlantilla = añosPlantilla;
        }
    }
    
    public static EmpleadoDeOficina nuevoEmpleadoDeOficina(){
        Scanner sc;
        Empleado e = Empleado.nuevoEmpleado();
        EmpleadoDeOficina ef = new EmpleadoDeOficina(e);
        System.out.println("Introcude los años en plantilla");
        int a;
        do {
            sc = new Scanner(System.in);
            a = sc.nextInt();
            ef.comprobarAñosplantilla(a);
        } while (ef.getAñosPlantilla() != a);
    return ef;}
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", años en plantilla" + añosPlantilla +'}';
    }
}
