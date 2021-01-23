/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import java.util.Scanner;
import java.util.ArrayList;
import Entidades.*;
public class Main {

    //main 
    public static void main(String[] args) {
        
        //Convertimos el array de empleados de la BS a ArrayList para poder trabajar con el
        ArrayList<Empleado> empleados = Empleado.convertirEmpleado(Utilidades.EMPLEADOS);
        //Convertimos el array de franquicias de la BS a ArrayList para poder trabajar con el
        ArrayList <Franquicia> franquicias = Franquicia.convertirFranquicia(Utilidades.FRANQUICIAS);
        //Convertimos el array de empleados de la BS a ArrayList para poder trabajar con el
        ArrayList<Informe> informes = Informe.convertirInforme(Utilidades.INFORMES);
        
        int opcion = -1;
        do {
            MostrarMenu();
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 3) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }
            switch (opcion) {
                case 1: //Gestión de Franquicias
                    System.out.println("Has entrado en la Gestión de Franquicias.");
                    int opcionFran = -1;
                    do {
                        MostrarMenuFranquicias();
                        opcionFran = in.nextInt();
                        if (opcionFran < 0 || opcionFran > 3){
                            System.out.println("Opción equivocada. Vuelva a introducir la opción.");
                            continue;
                        }
                        switch (opcionFran){
                            case 1: // Ver Franquicias
                                Franquicia.verFranquicias(franquicias);
                                break;
                            case 2: // Crear Franquicia
                                break;
                            case 3: 
                                System.out.println("Introduzca la ID de la Franquicia que quiera buscar.");
                                int opcionId = in.nextInt();
                                Franquicia.buscarFranquicia(opcionId);
                                
                                break;
                            default: 
                        }
                    } while(opcionFran < 0 || opcionFran > 3);
                    break;
                case 2: //Gestión de Empleados
                    System.out.println("Has entrado en la Gestión de Empleados!");
                    int opcionemp = -1;
                    do {
                        MostrarMenuEmpleados();
                        opcionemp = in.nextInt();
                        if (opcionemp < 0 || opcionemp > 3) {
                            System.out.println("Error. Vuelva a introducir la opción.");
                        }
                        switch (opcionemp){
                            case 1: //Ver Empleados
                                Empleado.mostrarEmpleados(empleados);
                                break;
                            case 2: //Nuevo Empleado
                                empleados.add(Empleado.nuevoEmpleado());
                                break;
                            case 3: //Buscar empleados
                                int opcionbusemp = -1;
                                do {
                                    MostrarMenuBuscarEmpleados();
                                    opcionbusemp = in.nextInt();
                                    if (opcionbusemp < 0 || opcionbusemp > 6) {
                                        System.out.println("Error. Vuelva a introducir la opción.");
                                    }
                                    switch(opcionbusemp){
                                        case 1: //Buscar por id
                                            System.out.println("Introduce la ID a buscar.");
                                            in = new Scanner(System.in);
                                            long id = in.nextLong();
                                            if (Empleado.getEmpleadobyID(id, empleados).getId() == 0) {
                                                System.out.println("No existe ningun empleado con la ID introducida.");
                                            } else{
                                                System.out.println(Empleado.getEmpleadobyID(id, empleados));
                                            }
                                            continue;
                                        case 2: //Buscar por nif
                                            System.out.println("Introduce el NIF a buscar.");
                                            in = new Scanner(System.in);
                                            String nif = in.nextLine();
                                            if (Empleado.getEmpleadobyNIF(nif, empleados).getNif() == null) {
                                                System.out.println("No existe ningun empleado con el NIF introducido.");
                                            } else{
                                                System.out.println(Empleado.getEmpleadobyNIF(nif, empleados));
                                            }
                                            continue;
                                        case 3: //Buscar por nombre
                                            System.out.println("Introduce el nombre a buscar.");
                                            in = new Scanner(System.in);
                                            String nombre = in.nextLine();
                                            if (Empleado.getEmpleadobyNombre(nombre, empleados).isEmpty()) {
                                                System.out.println("No existe ningun empleado con el nombre introducido.");
                                            } else{
                                                Empleado.mostrarEmpleados(Empleado.getEmpleadobyNombre(nombre, empleados));
                                            }
                                            continue;
                                        case 4: //Buscar por apellidos
                                            System.out.println("Introduce el apellido a buscar,");
                                            in = new Scanner(System.in);
                                            String apellidos = in.nextLine();
                                            if (Empleado.getEmpleadobyApellidos(apellidos, empleados).isEmpty()) {
                                                System.out.println("No existe ningun empleado con el apellido introducido.");
                                            } else{
                                                Empleado.mostrarEmpleados(Empleado.getEmpleadobyApellidos(apellidos, empleados));
                                            }
                                            continue;
                                        case 5: //Buscar por direccion
                                            System.out.println("Introduce la direccion a buscar.");
                                            in = new Scanner(System.in);
                                            String direccion = in.nextLine();
                                            if (Empleado.getEmpleadobyDireccion(direccion, empleados).isEmpty()) {
                                                System.out.println("No existe ningun empleado con la direccion introducido.");
                                            } else{
                                                Empleado.mostrarEmpleados(Empleado.getEmpleadobyDireccion(direccion, empleados));
                                            }
                                            continue;
                                        case 6: //Buscar por telefono
                                            System.out.println("Introduce el telefono a buscar.");
                                            in = new Scanner(System.in);
                                            String telefono = in.nextLine();
                                            if (Empleado.getEmpleadobyTelefono(telefono, empleados).getId() == 0) {
                                                System.out.println("No existe ningun empelado con el telefono introducido.");
                                            } else{
                                                System.out.println(Empleado.getEmpleadobyTelefono(telefono, empleados));
                                            }            
                                    }
                                } while (opcionbusemp != 0);
                                
                                break;
                            default:
                                continue;
                        }
                        opcionemp = -1;
                    } while (opcionemp < 0 || opcionemp > 3);
                    break;
                case 3: //Gestión de Informes
                    System.out.println("Has entrado en la Gestión de Informes.");
                    int opcioninf = -1;
                    do{
                        MostrarMenuInformes();
                        opcioninf = in.nextInt();
                        if (opcioninf < 0 || opcioninf > 2) {
                            System.out.println("Error.Vuelva a introducir la opción.");
                    }
                    switch (opcioninf) {
                        case 1: //Ver informes
                            break;
                        case 2: // Nuevo informe 
                            break;
                        default:
                    }
                    opcioninf = -1;
                    } while (opcioninf < 0 || opcioninf > 2);
                break;
                default: //Salir
                    continue;
            }
            opcion = -1;
        } while (opcion < 0 || opcion > 3);

    }

    private static void MostrarMenu() {
        System.out.println("Pulsa 1 para entrar en Gestión de Franquicias.");
        System.out.println("Pulsa 2 para entrar en Gestión de Empleados.");
        System.out.println("Pulsa 3 para entrar en Gestión de Informes.");
        System.out.println("Pulsa 0 para salir.");
    }

    private static void MostrarMenuEmpleados() {
        System.out.println("Pulsa 1 para Ver Empleados.");
        System.out.println("Pulsa 2 para Nuevo Empleado.");
        System.out.println("Pulsa 3 para Busca Empleado.");
        System.out.println("Pulsa 0 para salir");
    } 
    private static void MostrarMenuFranquicias(){
        System.out.println("Pulsa 1 para ver franquicias.");
        System.out.println("Pulsa 2 para crear franquicias.");
        System.out.println("Pulsa 3 para buscar franquicias.");
        System.out.println("Pulsa 0 para salir del menú franquicias.");
        
    }
    
    private static void MostrarMenuInformes() {
        System.out.println("Pulsa 1 para ver informes.");
        System.out.println("Pulsa 2 para crear un nuevo informe.");
    }

    private static void MostrarMenuBuscarEmpleados() {
        System.out.println("Pulsa 1 para Buscar Empleados por Id");
        System.out.println("Pulsa 2 para Buscar Empleados por Nif.");
        System.out.println("Pulsa 3 para Buscar Empleados por Nombre.");
        System.out.println("Pulsa 4 para Buscar Empleados por Apelidos.");
        System.out.println("Pulsa 5 para Buscar Empleados por Direccion.");
        System.out.println("Pulsa 6 para Buscar Empleados por Telefono.");
        System.out.println("Pulsa 0 para salir.");
    }
}
