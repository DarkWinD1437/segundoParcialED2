/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaABB;

/**
 *
 * @author Alan
 */
public class Nodo {
    public Nodo izq;
    public Nodo der;
    public String str;
    public int frecuencia;
    
    public Nodo (String str){
        this.str=str;
        izq=der=null;
        this.frecuencia = 1;
    }
    
}
