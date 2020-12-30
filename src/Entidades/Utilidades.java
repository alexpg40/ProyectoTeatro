/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Utilidades {

    //He declarado la Franquicia para que no me de error
    static Franquicia Franquicia;
    //long id String nombre String apellidos String nif String direccion String telefono Franquicia Franquicia
    public static final Empleado EMPLEADOS[] = {
        new Empleado(1, "Amelio", "Pascual", "12345678A", "Madrid, Las Rozas", "293 932 238", Franquicia),
        new Empleado(2, "Jose Juan", "Garcia", "23456789S", "Cantabria, Soto", "123 431 314", Franquicia),
        new Empleado(3, "Pepe", "Perez", "34567891A", "Alicante", "134 123 764", Franquicia),
        new Empleado(4, "Aitor", "Mendizabal", "54348943C", "Murcia", "345 501 459", Franquicia),
        new Empleado(5, "Josito", "Fernandez", "83774591A", "Galicia, Vigo", "123 459 230", Franquicia),
        new Empleado(6, "Alex", "Perez", "34912312A", "Cantabria", "124 451 123", Franquicia),
        new Empleado(7, "Guillermo", "Illera", "45913412F", "Cantabria", "459 213 459", Franquicia),
        new Empleado(8, "Sandra", "Burgos", "34939139A", "Cantabria", "864 344 459", Franquicia),
        new Empleado(9, "Pepito", "Garcia", "49583943V", "Almeria", "495 459 348", Franquicia)

    };

    //He declarado un ArrayList para que no me de error
    static ArrayList<EmpleadoDeTeatro> EmpleadosTeatro = new ArrayList<>();
    //long id long semana ArrayListo <EmpleadosDeTeatro> EmpleadosTeatro Franquicia franquicia 
    public static final GTrabajo GTRABAJO[] = {
        new GTrabajo(1, 3, Franquicia, EmpleadosTeatro),
        new GTrabajo(2, 1, Franquicia, EmpleadosTeatro),
        new GTrabajo(5, 7, Franquicia, EmpleadosTeatro),
        new GTrabajo(3, 6, Franquicia, EmpleadosTeatro),
        new GTrabajo(9, 2, Franquicia, EmpleadosTeatro),};

    //He declarado la nomina por lo mismo xD
    static Nomina nomina;
    //char categoria Nomina nomina
    public static final EmpleadoDeTeatro EMPLEADOSDETEATRO[] = {
        new EmpleadoDeTeatro(EMPLEADOS[0], 'A', nomina),
        new EmpleadoDeTeatro(EMPLEADOS[1], 'C', nomina),
        new EmpleadoDeTeatro(EMPLEADOS[2], 'B', nomina),
        new EmpleadoDeTeatro(EMPLEADOS[3], 'A', nomina),
        new EmpleadoDeTeatro(EMPLEADOS[4], 'D', nomina)
    };

    //protected int
    public static final EmpleadoDeOficina EMPLEADOSDEOFICINA[] = {
        new EmpleadoDeOficina(EMPLEADOS[5], 1),
        new EmpleadoDeOficina(EMPLEADOS[6], 2),
        new EmpleadoDeOficina(EMPLEADOS[7], 3),
        new EmpleadoDeOficina(EMPLEADOS[8], 4)

    };
}
