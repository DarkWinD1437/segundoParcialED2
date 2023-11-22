/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolconlibrerialista;
import java.util.LinkedList;
/**
 *
 * @author SARA EUNICE
 */
public class ArbolConLibreriaLista {

    public static void main(String[] args) {
        Arbol A1 = new Arbol();
        A1.insertar(5);
        A1.insertar(3);
        A1.insertar(8);
        A1.insertar(2);
        A1.insertar(6);
        A1.insertar(9); // Se crea el ABB

        Arbol A2 = new Arbol();
        A2.insertar(5);
        A2.insertar(3);
        A2.insertar(8);
        A2.insertar(2);
        A2.insertar(6);
        A2.insertar(9);
//        LinkedList<Integer> L1 = new LinkedList();
//        A1.generarElem(5, 0, 10);
//        A1.niveles(L1);
//        A1.desc();
//        A1.mostrarAsc();
//        A1.invertTree();
//        A1.inOrden();
//        A1.sumarNivel(L1);
        System.out.println(A1.isSameTree(A2)); 

    }
}
