/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import Entidades.Empleado;
import Entidades.EmpleadoDeTeatro;
import Entidades.GTrabajo;
import Entidades.EmpleadoDeOficina;

public class Main {
    //main
    public static void main(String[] args) {

        String a = "A";
        String nif = "12345618C";
        Empleado e = new Empleado();
        e.setNombre(a);
        e.comprobarNombre(a);
        e.comprobarNif(nif);
        e.comprobarTelefono("123356789");
        
        GTrabajo g = new GTrabajo();
        g.comprobarSemana(5);
        g.comprobarId(8);
        
        EmpleadoDeTeatro et = new EmpleadoDeTeatro();
        et.comprobarCategoria('D');
        
        EmpleadoDeOficina ef = new EmpleadoDeOficina();
        ef.comprobarAñosplantilla(0);
    }
}