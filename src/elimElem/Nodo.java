/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elimElem;

/**
 *
 * @author Alan
 */
public class Nodo {
    Nodo izq;
    Nodo der;
    int elem;
    int frecuencia;
    
    public Nodo(int x){
        izq = der = null;
        this.elem = x;
        this.frecuencia = 1;
    }
}