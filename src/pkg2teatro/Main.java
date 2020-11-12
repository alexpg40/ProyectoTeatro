/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner u1 = new Scanner(System.in);
        
        System.out.println("Introduce tu nombre");
        
        String nombre = u1.nextLine();
        
        System.out.println("Introduce tus apellidos");
        
        String apellidos = u1.nextLine();
        
        System.out.println("Introduce tu NIF");
        
        String nif = u1.nextLine();
        
        System.out.println("Introduce tu telefono");
        
        String telefono = u1.nextLine();
        
        System.out.println("Introduce tu email");
        
        String email = u1.nextLine();
        
        System.out.println("Hola " + nombre + ", ¿quieres comprar un bono?");
    }
    
}
