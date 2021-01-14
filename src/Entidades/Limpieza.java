/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author DarkB
 */
public class Limpieza extends EmpleadoDeTeatro {

    //Los empleados generan un coste que reportan y se guardan en el arraylist
    private ArrayList<Coste> costes = new ArrayList<>();

    public Limpieza() {
        super();
    }

    public Limpieza(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public Limpieza(Empleado e, char categoria, Nomina nomina) {
        super(e, categoria, nomina);
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", categoria" + categoria + '}';
    }

    public ArrayList<Coste> getBeneficios() {
        return costes;
    }

    public void setBeneficios(ArrayList<Coste> beneficios) {
        this.costes = beneficios;
    }
}
