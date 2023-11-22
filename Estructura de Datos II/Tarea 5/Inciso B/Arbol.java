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
    
    public Arbol() {
        raiz=null;
    }
    
    public void insertar(String str) {
        raiz=insertar(raiz,str);
    }
    
    private Nodo insertar(Nodo p, String str){
        if (p==null) return new Nodo(str);
        if (str.compareTo(p.str)<0)
            p.izq=insertar(p.izq,str);
        else
            p.der=insertar(p.der,str);
        return p;
    }
    
    public void eliminar(String str){
        raiz=eliminar(raiz,str);
    }
    
    public Nodo eliminar(Nodo p, String str)
    {
        if(p==null) return null;
         int comparacion = str.compareTo(p.str);
        if (comparacion==0) return eliminarNodo(p);  
        if (comparacion<0)
            p.izq=eliminar(p.izq,str);
        else
            p.der=eliminar(p.der,str);
        return p;
    }
    
    public Nodo eliminarNodo(Nodo p){
        if (p == null) {
            return null; // Manejar el caso cuando el nodo es nulo
        }
        if(p.izq==null && p.der==null) return null;
        if(p.izq==null && p.der!=null) return p.der;
        if(p.izq!=null && p.der==null) return p.izq;
        Nodo q=p.der;
        while (q.izq!=null)
            q=q.izq;
        q.izq=p.izq;
        return p.der;
    }
    
    public void eliminarRaiz() {
        raiz = eliminarNodo(raiz);
    }
    
    public void eliminarHojas() {
        raiz = eliminarHojas(raiz);
    }

    private Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        }

        // Si es una hoja, eliminar el nodo
        if (p.izq == null && p.der == null) {
            //System.out.println("Eliminando hoja: " + p.elem);
            return null;
        }

        // Recursivamente eliminar hojas en los subárboles
        p.izq = eliminarHojas(p.izq);
        p.der = eliminarHojas(p.der);

        return p;
    }

    
    public void Asc(){
        Asc(raiz);
    }
    
    private void Asc(Nodo p){
        if (p==null) return;
        Asc(p.izq);
        System.out.println(p.str);
        Asc(p.der);
    }
    
    public void Desc(){
        Desc(raiz);
    }
    
    private void Desc(Nodo p){
        if (p==null) return;
        Desc(p.der);
        System.out.println(p.str);
        Desc(p.izq);
    }
    
    //Cantidad
    public int cantidad() {
        return cantidad(raiz);
    }
    
    private int cantidad(Nodo p){
        if (p==null) return 0;
        return 1+cantidad(p.izq)+cantidad(p.der);
    }
    
    //Altura
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo p) {
        if (p == null) {
            return 0;
        }

        int alturaIzq = altura(p.izq);
        int alturaDer = altura(p.der);

        return 1 + Math.max(alturaIzq, alturaDer);
    }
}
