/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author SARA EUNICE
 */
public class Arbol {
    public Nodo raiz;
    
    public Arbol(){
        raiz=null;
    }
    
    public void insertar(String str){
        raiz=insertar(raiz, str);
    }
    
    private Nodo insertar(Nodo p, String str){
        if (p==null) return new Nodo(str);
        if (str.compareTo(p.str)<0) 
            p.izq=insertar(p.izq,str);
        else 
            p.der=insertar(p.der,str);
        return p;
    }
    
    // Altura
    public int altura(){
        return altura(raiz);
    }
    
    private int altura(Nodo p){
        if (p==null) return 0;
        int altIzq=altura(p.izq);
        int altDer=altura(p.der);
        return 1+Math.max(altIzq, altDer);
    }
    
    //Mostrar Ascendente
    public void Asc(){
        Asc(raiz);
    }
    
    private void Asc(Nodo p){
        if (p==null) return;
        Asc(p.izq);
        System.out.println(p.str);
        Asc(p.der);
    }
    
    //cantidad de nodos
    public int cantidad(){
        return cantidad(raiz);
    }
    
    private int cantidad(Nodo p){
        if (p==null) return 0;
        return 1+cantidad(p.izq)+cantidad(p.der);
    }
}
