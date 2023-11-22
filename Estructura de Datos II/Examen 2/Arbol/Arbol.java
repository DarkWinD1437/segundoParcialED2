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
    
    public void insertar(int e){
        raiz=insertar(raiz, e);
    }
    
    private Nodo insertar(Nodo p, int e){
        if (p==null) return new Nodo(e);
        if (e<p.elem) 
            p.izq=insertar(p.izq,e);
        else 
            p.der=insertar(p.der,e);
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
        System.out.println(p.elem);
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
    
    //mayor
    public int mayor(){
        return mayor(raiz);
    }
    
    private int mayor(Nodo p){
        if (p.der==null) return p.elem;
        return mayor(p.der);
    }
    
    //suma 
    public int suma(){
        return suma(raiz);
    }
    
    private int suma(Nodo p){
        if (p==null) return 0;
        return p.elem+suma(p.izq)+suma(p.der);
    }
    
    //generar aleatorio
    public void generarElem(int n, int a, int b){
        int at;
        for (int i=1; i<=n; i++) {
            at= (int) (Math.random()*((b+1)-a)+a);
            insertar(at);
        }
    }
}
