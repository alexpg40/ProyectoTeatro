/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

public class EmpleadoDeTeatro extends Empleado {
    
    protected char categoria;
    //Cada empleado de teatro tiene una nomina que es calculada por secretario y revisada por direccion
    private Nomina nomina;
   
    public EmpleadoDeTeatro(){
        super();
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public EmpleadoDeTeatro(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria, Nomina nomina){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
        this.nomina = nomina;
    }
    public EmpleadoDeTeatro(Empleado e, char categoria, Nomina nomina){
        super(e);
        this.categoria = categoria;
        this.nomina = nomina;
    }
    
    public void comprobarCategoria(char categoria){
        if (categoria != 'A' && categoria !='B' && categoria !='C' && categoria !='D') {
            System.out.println("La categoria solo puede ser A, B, C o D");
        } else{
            this.categoria = categoria;
        }
    }
    public EmpleadoDeTeatro nuevoEmpleadoDeTeatro(){
        EmpleadoDeTeatro e = new EmpleadoDeTeatro();
        Scanner sc = new Scanner(System.in);
        e.comprobarId();
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
        System.out.println("Introduce la categoria");
        char c = 0;
        do {
            c = 0;
            sc = new Scanner(System.in);
            c = sc.next().charAt(c);
            e.comprobarCategoria((char) c);
        } while (e.getCategoria() != c);
    return e;}
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", categoria" + categoria +'}';
    }
}
