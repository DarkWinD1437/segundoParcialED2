/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elemABB;

/**
 *
 * @author Alan
 */
public class Nodo {
    public Nodo izq;
    public Nodo der;
    public int elem;
    
    public Nodo (int x){
        elem = x;
        izq = der = null;
    }
}
