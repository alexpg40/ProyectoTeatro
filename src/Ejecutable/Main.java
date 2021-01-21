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
        
        //Convertirmos el array de empleados de la BS a ArrayList para poder trabajar con el
        ArrayList<Empleado> empleados = Empleado.convertirEmpleado(Utilidades.EMPLEADOS);
        
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
                        }
                    } while (opcionemp < 0 || opcionemp > 3);
                    break;
                case 3: //Gestión de Informes
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
}
