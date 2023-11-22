/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author SARA EUNICE
 */
public class ArbolString {
    public Nodo raiz;
    
    public ArbolString() {
        raiz=null;
    }
    
    public void insertar(String valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, String valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        int comparacion = valor.compareTo(nodo.valor);

        if (comparacion == 0) {
            nodo.frec++;
        } else if (comparacion < 0) {
            nodo.izq = insertarRecursivo(nodo.izq, valor);
        } else {
            nodo.der = insertarRecursivo(nodo.der, valor);
        }

        return nodo;
    }
    
    //Mostrar los elementos de menor a mayor con sus respectivas frecuencias de ocurrencias.
    
    public void maMelementos() {
        maMelementos(raiz);
    }
    
    private void maMelementos(Nodo p) {
        if (p==null) return;
        maMelementos(p.izq);
        System.out.println("elemento:"+p.valor+"; frecuencia:"+p.frec);
        maMelementos(p.der);
    }
    
    //Mostrar los elementos de mayor  a menor con sus respectivas frecuencias de ocurrencias.
    public void Mamelementos() {
        Mamelementos(raiz);
    }
    
    private void Mamelementos(Nodo p) {
        if (p==null) return;
        Mamelementos(p.der);
        System.out.println("elemento:"+p.valor+"; frecuencia:"+p.frec);
        Mamelementos(p.izq);
    }
    
    //Mostrar los elementos, asociados con sus frecuencias de menor a mayor.
    
    public void maMFrecuencias() {
        List<Nodo> nodos = new ArrayList<>();
        recopilar(raiz, nodos);
        ordenar(nodos);
        mostrar(nodos);
    }

    private void recopilar(Nodo nodo, List<Nodo> nodos) {
        if (nodo != null) {
            recopilar(nodo.izq, nodos);
            nodos.add(nodo);
            recopilar(nodo.der, nodos);
        }
    }

    private void ordenar(List<Nodo> nodos) {
        Collections.sort(nodos, Comparator.comparingInt(n -> n.frec));
    }

    private void mostrar(List<Nodo> nodos) {
        for (Nodo nodo : nodos) {
            System.out.println("Valor: " + nodo.valor + " - Frecuencia: " + nodo.frec);
        }
    }
    
    //Mostrar los elementos, asociados con sus frecuencias de mayor a menor.
    public void MamFrecuencias() {
        List<Nodo> nodos = new ArrayList<>();
        recopilar2(raiz, nodos);
        ordenar2(nodos);
        mostrar2(nodos);
    }

    private void recopilar2(Nodo nodo, List<Nodo> nodos) {
        if (nodo != null) {
            recopilar2(nodo.izq, nodos);
            nodos.add(nodo);
            recopilar2(nodo.der, nodos);
        }
    }

    private void ordenar2(List<Nodo> nodos) {
        Collections.sort(nodos, (n1, n2) -> n2.frec - n1.frec);
    }

    private void mostrar2(List<Nodo> nodos) {
        for (Nodo nodo : nodos) {
            System.out.println("Valor: " + nodo.valor + " - Frecuencia: " + nodo.frec);
        }
    }
}
