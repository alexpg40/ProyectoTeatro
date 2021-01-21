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
                            case 3: // Buscar Franquicias
                                
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
                                break;
                            case 2: //Nuevo Empleado
                                break;
                            case 3: //Buscar empleados
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
        System.out.println("Pulsa 1 para ver empleados.");
        System.out.println("Pulsa 2 para nuevo empleado.");
        System.out.println("Pulsa 3 para busca empleado.");
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

}
