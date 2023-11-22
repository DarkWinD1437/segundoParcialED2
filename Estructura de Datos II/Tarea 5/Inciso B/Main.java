/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.util.ArrayList;

/**
 *
 * @author SARA EUNICE
 */
public class Main {

    public static void main(String[] args) {
        ListaArbol L1= new ListaArbol(20);
        L1.insertar("abc");
        L1.insertar("xyz");
        L1.insertar("i");
        L1.insertar("pq");
        L1.insertar("a");
        L1.insertar("bc");
        L1.insertar("xy");
        L1.insertar("e");
        L1.insertar("stu");
        L1.insertar("ef");
        L1.insertar("o");
        L1.insertar("st");
        L1.insertar("bcd");
        L1.insertar("vw");
        L1.insertar("vm");
//        L1.insertar("mno");
//        L1.insertar("shd");
//        L1.insertar("hdy");
        L1.insertar("vwr");
//        L1.insertar("def");
        L1.insertar("u");
        L1.palabrasAscAsc();
        System.out.println("---------------------------------------------------------------");
//        Arbol ArbolMenor=L1.arbolPequeno();
//        Arbol ArbolMayor=L1.arbolGrande();
//        ArbolMayor.Asc();
//        Arbol igualTamaño= L1.igualTamaño();  
//        System.out.println(L1.arbolAsc());
        Arbol ArbolMasAlto=L1.arbolGrande();
        ArbolMasAlto.Asc();
    }
}
