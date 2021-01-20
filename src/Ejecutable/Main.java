/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import java.util.Scanner;

public class Main {

    //main 
    public static void main(String[] args) {
        
        int opcion = -1;
        do {
            MostrarMenu();
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
                if (opcion < 0 || opcion > 3) {
                    System.out.println("Error. Vuelva a introducir la opción");
            }
                switch(opcion){
                    case 1: //Gestión de Franquicias
                        break;
                    case 2: //Gestión de Empleados
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
}
