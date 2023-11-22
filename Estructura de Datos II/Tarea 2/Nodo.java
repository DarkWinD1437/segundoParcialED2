/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolconlibrerialista;

/**
 *
 * @author SARA EUNICE
 */
public class Nodo {
    public Nodo izq;
    public int elem;
    public Nodo der;
    
    public Nodo(int x){
        elem=x;
        izq=der=null;
    }
}
