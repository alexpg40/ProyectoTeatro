/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
        new Empleado(5, "Josito", "Fernandez", "83774591A", "Galicia, Vigo", "123 459 230", Franquicia)

    };

}
