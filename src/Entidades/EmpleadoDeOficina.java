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
        EmpleadoDeOficina e = new EmpleadoDeOficina();
        Scanner sc = new Scanner(System.in);
        e.setId(e.generarId());
        System.out.println("Introduce el nombre");
        String nomb;
        do {
            sc = new Scanner(System.in);
            nomb = sc.nextLine();
            e.comprobarNombre(nomb);
        } while (e.getNombre() != nomb);
        System.out.println("Introduce los apellidos");
        String ap;
        do {
            sc = new Scanner(System.in);
            ap = sc.nextLine();
            e.comprobarApellidos(ap);
        } while (e.getApellidos() != ap);
        System.out.println("Introduce el NIF");
        String nif;
        do {
            sc = new Scanner(System.in);
            nif = sc.nextLine();
            e.comprobarNif(nif);
        } while (e.getNif() != nif);
        System.out.println("Introduce el telefono");
        String tl;
        do {
            sc = new Scanner(System.in);
            tl = sc.nextLine();
            e.comprobarTelefono(tl);
        } while (e.getTelefono() != tl);
        System.out.println("Introduce la dirección");
        String d;
        do {
            sc = new Scanner(System.in);
            d = sc.nextLine();
            e.comprobarDireccion(d);
        } while (e.getDireccion() != d);
        System.out.println("Introcude los años en plantilla");
        int a;
        do {
            sc = new Scanner(System.in);
            a = sc.nextInt();
            e.comprobarAñosplantilla(a);
        } while (e.getAñosPlantilla() != a);
    return e;}
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", años en plantilla" + añosPlantilla +'}';
    }
}
