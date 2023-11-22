/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author SARA EUNICE
 */
public class Main {

    public static void main(String[] args) {
        Arbol A1= new Arbol();
        A1.insertar(5);
        A1.insertar(3);
        A1.insertar(8);
        A1.insertar(2);
        A1.insertar(6);
        A1.insertar(9);
//        A1.postOrden()
        
        System.out.println(A1.inmediatoInf(2));
    }
}
