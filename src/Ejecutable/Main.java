/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import Entidades.*;

public class Main {

    //main
    public static void main(String[] args) {

        Empleado e = new Empleado();
        e.nuevoEmpleado();

        GTrabajo g = new GTrabajo();
        g.nuevoGTrabajo();

        EmpleadoDeTeatro et = new EmpleadoDeTeatro();
        et.nuevoEmpleadoDeTeatro();

        EmpleadoDeOficina ef = new EmpleadoDeOficina();
        ef.nuevoEmpleadoDeOficina();
        
        Coste c = new Coste();
        c.nuevoCoste();
        
        Usuario u = new Usuario();
        u.nuevoUsuario();
    }
}
