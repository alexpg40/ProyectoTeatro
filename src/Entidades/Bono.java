package Entidades;

import java.util.ArrayList;

public class Bono {
    private long id;
    // Valores válidos: Números > 0| Valores inválidos: Números <=0 | Otras restricciones: No puede repetirse, solo enteros.
    private char tipo;
    // Valores válidos: "P" y "C" | Valores inválidos: Caracter diferente, null o vacío.| Otras restricciones: Parcial solo sirve para el fin de semana. (Los cojones voy a saber hacer yo esto)
    private int mes;
    // Valores válidos: Número entero entre 1 y 12.| Valores inválidos: Cualquier número o carácter distinto que no esté comprendido entre 1 y 12, null y vacío.
    private Usuario usuario;
    
    
    public Bono () {
        
    }
    
    public Bono (long id, char tipo, int mes) {
        this.id = id;
        this.tipo = tipo;
        this.mes = mes;
    }
    
     public Bono (Bono bono){
        this.id = bono.id;
        this.tipo = bono.tipo;
        this.mes = bono.mes;
    }
    
    public long getId () {
        return id;
    }
    
    public void setId (long id) {
        this.id = id;
    }
    
    public char getTipo () {
        return tipo;
    }
    
    public void setTipo (char tipo) {
        this.tipo = tipo;
    }
    
    public int getMes () {
        return mes;
    }
    
    public void setMes (int mes) {
        this.mes = mes;
    }
    
    public Usuario getUsuario () {
        return usuario;
    }
    
    public void setUsuario (Usuario usuario){
        this.usuario = usuario;
    }
    
    public void generarId(){
       this.id = Utilidades.BONOS.length + 1;
    }
    
    public void comprobarTipo (char tipo){
        
    };
    
    public void comprobarMes (int mes) {
        
    };
    
    public static Bono nuevoBono() {
        Bono b = new Bono();
        
        return b;
    };
     @Override
    public String toString() {
        return "Bono{" + "id=" + id + ", tipo=" + tipo + ", mes=" + mes + ", usuario=" + usuario + '}';
    }
}
