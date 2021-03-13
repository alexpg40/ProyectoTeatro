/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
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

    public int getAñosPlantillaD() {
        return añosPlantillaD;
    }

    public void setAñosPlantillaD(int añosPlantillaD) {
        this.añosPlantillaD = añosPlantillaD;
    }

    public Direccion() {
        super();
    }

    public Direccion(Empleado e) {
        super(e);
    }

    public Direccion(long id, String nombre, String apellidos, String nif, String direccion, String telefono, int añosPlantillaD) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.añosPlantillaD = añosPlantillaD;
    }

    public Direccion(Empleado e, int añosPlantilla) {
        super(e, añosPlantilla);
    }

    /**
     * Función que valida los años en plantilla del director
     *
     * @param añosPlantillaD
     * @return boolean
     */
    public boolean validarAñosPlantillaD(int añosPlantillaD) {
        if (!(añosPlantillaD >= 0 && añosPlantillaD < 80)) {
            System.out.println("Los años en plantilla tiene que estar entre 0 y 80");
        } else {
            return true;
        }
        return false;
    }

    public static Direccion nuevaDireccion(ArrayList<Empleado> empleados) {
        Scanner in = new Scanner(System.in);
        EmpleadoDeOficina e = EmpleadoDeOficina.nuevoEmpleadoDeOficina(empleados);
        Direccion direc = new Direccion(e);
        System.out.println("Introduce los años en plantilla.");
        int años = in.nextInt();
        direc.validarAñosPlantillaD(años);
        return direc;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.nombre + " " + this.apellidos + " Nif: " + this.nif + " Telefono: " + this.telefono + " (" + this.getClass().getSimpleName() + ")";
    }
}
