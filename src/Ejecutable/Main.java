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

        //Convertirmos todos los array de todos los tipos de empleados que hay para poder trabajar con ellos
        ArrayList<Empleado> empleadosD = Empleado.convertirEmpleado(Utilidades.DIRECCIONES);
        ArrayList<Empleado> empleadosL = Empleado.convertirEmpleado(Utilidades.LIMPIADORES);
        ArrayList<Empleado> empleadosA = Empleado.convertirEmpleado(Utilidades.ACOMODADORES);
        ArrayList<Empleado> empleadosS = Empleado.convertirEmpleado(Utilidades.SECRETARIOS);
        ArrayList<Empleado> empleadosT = Empleado.convertirEmpleado(Utilidades.TAQUILLEROS);

        //Declaro un ArrayList empleados donde guardo todos los tipos de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.addAll(empleadosL);
        empleados.addAll(empleadosA);
        empleados.addAll(empleadosT);
        empleados.addAll(empleadosS);
        empleados.addAll(empleadosD);
        //Convertimos el array de franquicias de la BS a ArrayList para poder trabajar con el
        ArrayList<Franquicia> franquicias = Franquicia.convertirFranquicia(Utilidades.FRANQUICIAS);
        //Convertimos el array de empleados de la BS a ArrayList para poder trabajar con el
        ArrayList<Informe> informes = Informe.convertirInforme(Utilidades.INFORMES);
        ArrayList<GTrabajo> grupostrabajo = GTrabajo.convertirGTrabajo(Utilidades.GTRABAJO);

        int opcion = -1;
        do {
            MostrarMenu();
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 4) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }
            switch (opcion) {
                case 1: //Gestión de Franquicias
                    System.out.println("Has entrado en la Gestión de Franquicias.");
                    int opcionFran = -1;
                    do {
                        MostrarMenuFranquicias();
                        opcionFran = in.nextInt();
                        if (opcionFran < 0 || opcionFran > 3) {
                            System.out.println("Opción equivocada. Vuelva a introducir la opción.");
                            continue;
                        }
                        switch (opcionFran) {
                            case 1: // Ver Franquicias
                                Franquicia.verFranquicias(franquicias);
                                break;
                            case 2: // Crear franquicia
                                break;
                            case 3:
                                Scanner opcionFranquicias = new Scanner(System.in);
                                int opcionMenuFran;
                                
                                System.out.println("Introduzca la opción que desee: " + "\n" +
                                        "1. Buscar franquicia por ID." + "\n" + 
                                        "2. Buscar franquicia por ubicacion." + "\n" +
                                        "3. Filtrar franquicias por accesibilidad para minusvalidos." + "\n" + 
                                        "4. Salir" + "\n");
                                
                                opcionMenuFran = opcionFranquicias.nextInt();
                                switch(opcionMenuFran){
                                
                                    case 1:
                                        int idFran;
                                        Scanner scId = new Scanner (System.in);
                                        System.out.println("Introduzca el ID de la franquicia.");
                                        idFran = scId.nextInt();
                                        Franquicia.buscarFranquicia(idFran);
                                        break;
                                        
                                    case 2:
                                        String UbFran;
                                        Scanner scUb = new Scanner (System.in);
                                        System.out.println("Introduzca la ubicación de la franquicia.");
                                        UbFran = scUb.nextLine();
                                        UbFran = UbFran.substring(0, 1).toUpperCase() + UbFran.substring(1).toLowerCase();
                                        Franquicia.buscarFranquicia(UbFran);
                                        break;
                                        
                                    case 3:
                                        System.out.println("Introduzca s para ver las franquicias con accesibilidad reducida. " + "\n" 
                                        + "Introduzca n para ver las franquicias sin accesibilidad reducida." + "\n");
                                        Franquicia.buscarFranquicia(Utilidades.leerBoolean());
                                        break;
                                }
                        } 
                    } while (opcionFran < 0 || opcionFran > 3);
                    break;
                case 2: //Gestión de Empleados
                    GestionEmpleados(empleados);
                    break;
                case 3: //Gestión de Informes
                    System.out.println("Has entrado en la Gestión de Informes.");
                    int opcioninf = -1;
                    do {
                        MostrarMenuInformes();
                        opcioninf = in.nextInt();
                        if (opcioninf < 0 || opcioninf > 2) {
                            System.out.println("Error.Vuelva a introducir la opción.");
                        }
                        switch (opcioninf) {
                            case 1: //Ver informes
                                Informe.verInformes(informes);
                                break;
                            case 2: // Nuevo informe 
                                informes.add(Informe.nuevoInforme());
                                break;
                            default:
                        }
                        opcioninf = -1;
                    } while (opcioninf < 0 || opcioninf > 2);
                    break;
                case 4: // Gestion de grupos de trabajo
                    int opcionMenuGrupos;
                    Scanner scMenuGrupos = new Scanner (System.in);
                    do {
                        mostrarMenuGrupos();
                        opcionMenuGrupos = scMenuGrupos.nextInt(); 
                        switch (opcionMenuGrupos) {
                        case 1:  // Ver
                            GTrabajo.verGruposTrabajo(grupostrabajo);
                            break;
                        case 2: // Buscar
                            int opcionBusquedaGrupos;
                            Scanner scBusquedaGrupos = new Scanner (System.in);
                            
                            do {
                                System.out.println("Has accedido al menú Busqueda de Grupos de trabajo." + "\n" 
                                    + "Seleccione 1 para buscar por ID." + "\n" 
                                    + "Seleccione 2 para buscar por Semana." + "\n"
                                    + "Seleccione 3 para salir. ");
                                opcionBusquedaGrupos = scBusquedaGrupos.nextInt();
                            } while(opcionBusquedaGrupos > 3);
                            switch(opcionBusquedaGrupos){
                                case 1:
                                    int busquedaId;
                                    Scanner scBusquedaId = new Scanner (System.in);
                                    System.out.println("Introduzca el ID con el que desea buscar el grupo.");
                                    busquedaId = scBusquedaId.nextInt();
                                    GTrabajo.getGTrabajobyID(busquedaId);
                                    break;
                                case 2:
                                    int Semana, Mes;
                                    Scanner scSemanaMes = new Scanner (System.in);
                                    System.out.println("Introduzca la semana: ");
                                    Semana = scSemanaMes.nextInt();
                                    System.out.println("Introduzca el mes: ");
                                    Mes = scSemanaMes.nextInt();
                                    GTrabajo.getGTrabajobySemana(Semana, Mes);
                                    break;
                                case 3:
                                    
                                    break;
                                default:
                            }
                            break;
                        case 3: // Gestionar
                            break;
                        case 4: // Salir
                            break;
                        default:
                    }
                    } while(opcionMenuGrupos > 4);
                    break;
                default: //Salir
                    continue;
            }
            opcion = -1;
        } while (opcion < 0 || opcion > 4);

    }

    private static void MostrarMenu() {
        System.out.println("-.- MENÚ PRINCIPAL -.-");
        System.out.println("Pulsa 1 para entrar en Gestión de Franquicias.");
        System.out.println("Pulsa 2 para entrar en Gestión de Empleados.");
        System.out.println("Pulsa 3 para entrar en Gestión de Informes.");
        System.out.println("Pulsa 4 para entrar en la Gestion de los Grupos de trabajo.");
        System.out.println("Pulsa 0 para salir.");
    }

    private static void MostrarMenuEmpleados() {
        System.out.println("Pulsa 1 para Ver Empleados.");
        System.out.println("Pulsa 2 para Nuevo Empleado.");
        System.out.println("Pulsa 3 para Buscar Empleado.");
        System.out.println("Pulsa 0 para salir");
    }

    private static void MostrarMenuFranquicias() {
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
        System.out.println("Pulsa 0 para Salir.");
    }

    private static void MostrarMenuNuevoEmpleados() {
        System.out.println("Pulsa 1 para Nuevo Acomodador.");
        System.out.println("Pulsa 2 para Nuevo Direccion.");
        System.out.println("Pulsa 3 para Nuevo Limpiador");
        System.out.println("Pulsa 4 para Nuevo Secretariado.");
        System.out.println("Pulsa 5 para Nuevo Taquillero.");
        System.out.println("Pulsa 0 para Salir.");
    }

    private static void mostrarMenuGrupos() {
        System.out.println("Has accedido al menú de Gestion de Grupos de trabajo.");
        System.out.println("Presione 1 para ver los Grupos de trabajo." + "\n" 
                + "Presione 2 para  buscar grupos de trabajo." + "\n" 
                + "Presione 3 para gestionar grupos de trabajo." + "\n" 
                + "Presione 4 para salir.");
    };
    private static void GestionEmpleados(ArrayList<Empleado> empleados) {
        Scanner in = new Scanner(System.in);
        System.out.println("Has entrado en la Gestión de Empleados!");
        int opcionemp = -1;
        do {
            MostrarMenuEmpleados();
            opcionemp = in.nextInt();
            if (opcionemp < 0 || opcionemp > 3) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }
            switch (opcionemp) {
                case 1: //Ver Empleados
                    Empleado.mostrarEmpleados(empleados);
                    break;
                case 2: //Nuevo Empleado
                    NuevoEmpleado(empleados);
                    break;
                case 3: //Buscar empleados
                    BuscarEmpleado(empleados);
                    break;
                default:
                    continue;
            }
            opcionemp = -1;
        } while (opcionemp < 0 || opcionemp > 3);
    }

    private static void BuscarEmpleado(ArrayList<Empleado> empleados) {
        int opcionbusemp = -1;
        Scanner in = new Scanner(System.in);
        do {
            MostrarMenuBuscarEmpleados();
            opcionbusemp = in.nextInt();
            if (opcionbusemp < 0 || opcionbusemp > 6) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }
            switch (opcionbusemp) {
                case 1: //Buscar por id
                    System.out.println("Introduce la ID a buscar.");
                    in = new Scanner(System.in);
                    long id = in.nextLong();
                    if (Empleado.getEmpleadobyID(id, empleados).getId() == 0) {
                        System.out.println("No existe ningun empleado con la ID introducida.");
                    } else {
                        System.out.println(Empleado.getEmpleadobyID(id, empleados));
                    }
                    continue;
                case 2: //Buscar por nif
                    System.out.println("Introduce el NIF a buscar.");
                    in = new Scanner(System.in);
                    String nif = in.nextLine();
                    if (Empleado.getEmpleadobyNIF(nif, empleados).getNif() == null) {
                        System.out.println("No existe ningun empleado con el NIF introducido.");
                    } else {
                        System.out.println(Empleado.getEmpleadobyNIF(nif, empleados));
                    }
                    continue;
                case 3: //Buscar por nombre
                    System.out.println("Introduce el nombre a buscar.");
                    in = new Scanner(System.in);
                    String nombre = in.nextLine();
                    if (Empleado.getEmpleadobyNombre(nombre, empleados).isEmpty()) {
                        System.out.println("No existe ningun empleado con el nombre introducido.");
                    } else {
                        Empleado.mostrarEmpleados(Empleado.getEmpleadobyNombre(nombre, empleados));
                    }
                    continue;
                case 4: //Buscar por apellidos
                    System.out.println("Introduce el apellido a buscar,");
                    in = new Scanner(System.in);
                    String apellidos = in.nextLine();
                    if (Empleado.getEmpleadobyApellidos(apellidos, empleados).isEmpty()) {
                        System.out.println("No existe ningun empleado con el apellido introducido.");
                    } else {
                        Empleado.mostrarEmpleados(Empleado.getEmpleadobyApellidos(apellidos, empleados));
                    }
                    continue;
                case 5: //Buscar por direccion
                    System.out.println("Introduce la direccion a buscar.");
                    in = new Scanner(System.in);
                    String direccion = in.nextLine();
                    if (Empleado.getEmpleadobyDireccion(direccion, empleados).isEmpty()) {
                        System.out.println("No existe ningun empleado con la direccion introducido.");
                    } else {
                        Empleado.mostrarEmpleados(Empleado.getEmpleadobyDireccion(direccion, empleados));
                    }
                    continue;
                case 6: //Buscar por telefono
                    System.out.println("Introduce el telefono a buscar.");
                    in = new Scanner(System.in);
                    String telefono = in.nextLine();
                    if (Empleado.getEmpleadobyTelefono(telefono, empleados).getId() == 0) {
                        System.out.println("No existe ningun empelado con el telefono introducido.");
                    } else {
                        System.out.println(Empleado.getEmpleadobyTelefono(telefono, empleados));
                    }
            }
        } while (opcionbusemp != 0);
    }

    private static void NuevoEmpleado(ArrayList<Empleado> empleados) {
        Scanner in = new Scanner(System.in);
        int opcionnuevoemp = -1;
        do {
            MostrarMenuNuevoEmpleados();
            opcionnuevoemp = in.nextInt();
            if (opcionnuevoemp < 0 || opcionnuevoemp > 5) {
                System.out.println("Error. Vuelva a introducir la opción.");
            }
            switch (opcionnuevoemp) {
                case 1: //Nuevo Acomodador
                    empleados.add(Acomodador.nuevoAcomodador(empleados));
                    continue;
                case 2: // Nuevo Director
                    empleados.add(Direccion.nuevaDireccion(empleados));
                    continue;
                case 3: //Nuevo Limpiador
                    empleados.add(Limpieza.nuevoLimpieza(empleados));
                    continue;
                case 4: //Nuevo Secretario
                    empleados.add(Secretariado.nuevoSecretariado(empleados));
                    continue;
                case 5: //Nuevo Taquillero
                    empleados.add(Taquillero.nuevoTaquillero(empleados));
            }
        } while (opcionnuevoemp != 0);
    }
}
