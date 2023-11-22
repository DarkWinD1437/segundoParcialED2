/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author SARA EUNICE
 */
public class Nodo {
    public Nodo izq;
    public Nodo der;
    public int elem;
    public int frec;
    
    public Nodo(int x) {
        izq=der=null;
        elem=x;
        frec=1;
    }
}
