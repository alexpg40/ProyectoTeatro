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
public class Acomodador extends EmpleadoDeTeatro {

    //Los acomodadores reportan varios costes que se guardaran en un arraylist
    private ArrayList<Coste> costes = new ArrayList<>();

    public Acomodador() {
        super();
    }
    
    public Acomodador(Empleado e){
        super(e);
    }

    public Acomodador(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public Acomodador(Empleado e, char categoria, Nomina nomina) {
        super(e, categoria, nomina);
    }

    @Override
    public String toString() {
        String ret = this.id + ". " + this.nombre + " " + this.apellidos + " Nif: " + this.nif + " Telefono: " + this.telefono + " (" + this.getClass().getSimpleName() + ")";
        for (Coste cos : costes) {
            ret += "Importe:" + cos.getImporte() + "\n";
        }
        ret += '}';
        return ret;
    }

    public ArrayList<Coste> getCostes() {
        return costes;
    }

    public void setBeneficios(ArrayList<Coste> costes) {
        this.costes = costes;
    }
    
    public static Acomodador nuevoAcomodador(){
        EmpleadoDeTeatro e = EmpleadoDeTeatro.nuevoEmpleadoDeTeatro();
        Acomodador a = new Acomodador(e);
    return a;}
    
}
