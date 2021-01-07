package Entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Utilidades {

    
    //He declarado la Franquicia para que no me de error
    static Franquicia Franquicia;
    //long id, String nombre, String apellidos, String nif, String direccion, String telefono, Franquicia Franquicia
    public static final Empleado EMPLEADOS[] = {
        new Empleado(1, "Amelio", "Pascual", "12345678A", "Madrid, Las Rozas", "293932238", Franquicia),
        new Empleado(2, "Jose Juan", "Garcia", "23456789S", "Cantabria, Soto", "123431314", Franquicia),
        new Empleado(3, "Pepe", "Perez", "34567891A", "Alicante", "134123764", Franquicia),
        new Empleado(4, "Aitor", "Mendizabal", "54348943C", "Murcia", "345501459", Franquicia),
        new Empleado(5, "Josito", "Fernandez", "83774591A", "Galicia, Vigo", "123459230", Franquicia),
        new Empleado(6, "Alex", "Perez", "34912312A", "Cantabria", "124451123", Franquicia),
        new Empleado(7, "Guillermo", "Illera", "45913412F", "Cantabria", "459213459", Franquicia),
        new Empleado(8, "Sandra", "Burgos", "34939139A", "Cantabria", "864344459", Franquicia),
        new Empleado(9, "Pepito", "Garcia", "49583943V", "Almeria", "495459348", Franquicia)

    };

    //He declarado un ArrayList para que no me de error
    static ArrayList<EmpleadoDeTeatro> EmpleadosTeatro = new ArrayList<>();
    //long id, long semana, ArrayList <EmpleadosDeTeatro> EmpleadosTeatro, Franquicia franquicia 
    public static final GTrabajo GTRABAJO[] = {
        new GTrabajo(1, 3, Franquicia, EmpleadosTeatro),
        new GTrabajo(2, 1, Franquicia, EmpleadosTeatro),
        new GTrabajo(5, 7, Franquicia, EmpleadosTeatro),
        new GTrabajo(3, 6, Franquicia, EmpleadosTeatro),
        new GTrabajo(9, 2, Franquicia, EmpleadosTeatro),};
    
        
    // long id, Date mesyano, otra vez ni puta idea de poner la fecha.
    
    public static final Nomina NOMINAS[] = {
        new Nomina(1,""),
        new Nomina(2,""),
        new Nomina(3,""),
        new Nomina(4,""),
        new Nomina(5,""),
        new Nomina(6,""),
        new Nomina(7,""),
        new Nomina(8,""),
        new Nomina(9,""),
    };
    
    //char categoria, Nomina nomina
    public static final EmpleadoDeTeatro EMPLEADOSDETEATRO[] = {
        new EmpleadoDeTeatro(EMPLEADOS[0], 'A', NOMINAS[0]),
        new EmpleadoDeTeatro(EMPLEADOS[1], 'C', NOMINAS[1]),
        new EmpleadoDeTeatro(EMPLEADOS[2], 'B', NOMINAS[2]),
        new EmpleadoDeTeatro(EMPLEADOS[3], 'A', NOMINAS[3]),
        new EmpleadoDeTeatro(EMPLEADOS[4], 'D', NOMINAS[4])
    };

    //protected int
    public static final EmpleadoDeOficina EMPLEADOSDEOFICINA[] = {
        new EmpleadoDeOficina(EMPLEADOS[5], 1),
        new EmpleadoDeOficina(EMPLEADOS[6], 2),
        new EmpleadoDeOficina(EMPLEADOS[7], 3),
        new EmpleadoDeOficina(EMPLEADOS[8], 4)

    };
    
    // long id, Date fecha, double importe, Acomodador acomodador, Nomina nomina, Informe informe
    // long id, Date fecha, double importe, Limpieza limpieza, Nomina nomina, Informe informe
    // Dan error porque no tengo ni puñetera idea de poner la fecha.
    
    public static final Coste COSTES[] = {
        new Coste(1,"", 23, 800.90, acomodador, limpieza, 1, informe),
        new Coste(2,"", 800, limpieza, 2, informe)
    };
    
    // long id, char tipo, int mes
    
    public static final Bono BONOS[] = {
        new Bono(1,'C', 5),
        new Bono(2, 'P', 8),
        new Bono(3, 'C', 6),
        new Bono(4, 'C', 1),
        new Bono(5, 'P', 12)
    };

    // long id, String nombre, String apellidos, String nif, String telefono, String email
    public static final Usuario USUARIOS[] = {
        new Usuario(1," Guillermo ", "Illera ", "21141255T ","648937009","guillermo.illera97@gmail.com"),
        new Usuario(1," Bernat ", "Cid ", "16874298G ","648941259","guillermo.illera97@gmail.com"),
        new Usuario(1," Candido ", "Cuellar ", "65100987H ","612684941","guillermo.illera97@gmail.com"),
        new Usuario(1," Mireya ", "Bustos ", "65160165T ","981985321","guillermo.illera97@gmail.com"),
        new Usuario(1," Elver ", "Galarga ", "91871326F ","648919849","guillermo.illera97@gmail.com")
    };
}
