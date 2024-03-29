/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sandr
 */
public class EmpleadoDeOficina extends Empleado {

    //VALORES VALIDOS: ENTERO => 0 Y ENTERO <= 80 && VALORES INVALIDOS: ENTEROS > 80 o < 0, CUALQUIER CARACTER DIFERENTE A UN NUMERO 
    protected int añosPlantilla;

    public EmpleadoDeOficina() {
        super();
    }

    public EmpleadoDeOficina(Empleado e) {
        super(e);
    }

    public EmpleadoDeOficina(Empleado e, int añosPlantilla) {
        super(e);
        this.añosPlantilla = añosPlantilla;
    }

    public EmpleadoDeOficina(Empleado e, int añosPlantilla, long idNomina){
        super(e);
        this.añosPlantilla = añosPlantilla;
        this.idnomina = idNomina;
    }
    
    public EmpleadoDeOficina(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria) {
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

    /**
     * Valida los años en plantilla
     *
     * @param añosPlantilla a validar
     * @return boolean
     */
    public boolean validarAñosplantilla(int añosPlantilla) {
        //Valida que los años sean entre 0 como minimo y 80 como máximo.
        if (!(añosPlantilla >= 0 && añosPlantilla < 80)) {
            System.out.println("Los años en plantilla tiene que estar entre 0 y 80");
            //Setea los años en plantilla del empleado.
        } else {
            return true;
        }
        return true;
    }

    /**
     * Crea y devuelve un empleado de oficina con los datos introducidos.
     *
     * @param empleados
     * @return
     */
    public static EmpleadoDeOficina nuevoEmpleadoDeOficina(ArrayList<Empleado> empleados) {
        Scanner sc;
        Empleado e = Empleado.nuevoEmpleado(empleados);
        EmpleadoDeOficina ef = new EmpleadoDeOficina(e);
        System.out.println("Introdude los años en plantilla");
        int a = 1;
        do {
            sc = new Scanner(System.in);
            try {
                a = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Solo se permiten números enteros");
                continue;
            }
            if (ef.validarAñosplantilla(a)) {
                ef.setAñosPlantilla(a);
            }
        } while (ef.getAñosPlantilla() != a);
        return ef;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", años en plantilla" + añosPlantilla + '}';
    }

    @Override
    public String data() {
        return this.id + "|" + this.nombre + "|" + this.apellidos + "|" + this.nif + "|" + this.direccion + "|" + this.telefono + "|" + this.añosPlantilla;
    }

}
