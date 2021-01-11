package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Bono {

    private long id;
    // Valores válidos: Números > 0| Valores inválidos: Números <=0 | Otras restricciones: No puede repetirse, solo enteros.
    private char tipo;
    // Valores válidos: "P" y "C" | Valores inválidos: Caracter diferente, null o vacío.| Otras restricciones: Parcial solo sirve para el fin de semana. (Los cojones voy a saber hacer yo esto)
    private int mes;
    // Valores válidos: Número entero entre 1 y 12.| Valores inválidos: Cualquier número o carácter distinto que no esté comprendido entre 1 y 12, null y vacío.
    private Usuario usuario;

    public Bono() {

    }

    public Bono(long id, char tipo, int mes) {
        this.id = id;
        this.tipo = tipo;
        this.mes = mes;
    }

    public Bono(Bono bono) {
        this.id = bono.id;
        this.tipo = bono.tipo;
        this.mes = bono.mes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void generarId() {
        this.id = Utilidades.BONOS.length + 1;
    }

    public void comprobarTipo(char tipo) {
        if (tipo != 'C' && tipo != 'P') {
            System.out.println("La categoria solo puede C (Completo) o P (Parcial)");
        } else {
            this.tipo = tipo;
        }
    }

    ;
    
    public void comprobarMes(int mes) {
        if (mes < 1) {
            System.out.println("No puede ser menor de 1.");
            nuevoBono();
        } else if (mes > 12) {
            System.out.println("No puede ser mayor de 12.");
        } else {
            this.mes = mes;
        };
    }

    ;
    
    public static Bono nuevoBono() {
        Bono b = new Bono();
        Scanner in = new Scanner(System.in);
        System.out.println("Introcude la categoria");
        char tipo = 0;
        do {
            tipo = 0;
            in = new Scanner(System.in);
            tipo = in.next().charAt(tipo);
            b.comprobarTipo((char) tipo);
        } while (b.getTipo() != tipo);
        int m;
        do {
            in = new Scanner(System.in);
            m = in.nextInt();
            b.comprobarMes(m);
        } while (b.getMes() != m);
        return b;
    }

    ;
     @Override
    public String toString() {
        return "Bono{" + "id=" + id + ", tipo=" + tipo + ", mes=" + mes + ", usuario=" + usuario + '}';
    }
}
