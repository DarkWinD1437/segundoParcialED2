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
    //---------para devolver el recorrido en string -----------------------
    public String recorridoAsc() {
        StringBuilder resultado = new StringBuilder();
        recorridoAsc(raiz, resultado);
        return resultado.toString();
    }

    private void recorridoAsc(Nodo nodo, StringBuilder resultado) {
        if (nodo != null) {
            recorridoAsc(nodo.izq, resultado);
            resultado.append(nodo.str).append(" ");
            recorridoAsc(nodo.der, resultado);
        }
    }
    
    public String recorridoDesc() {
        StringBuilder resultado = new StringBuilder();
        recorridoDesc(raiz, resultado);
        return resultado.toString();
    }

    private void recorridoDesc(Nodo nodo, StringBuilder resultado) {
        if (nodo != null) {
            recorridoDesc(nodo.der, resultado);
            resultado.append(nodo.str).append(" ");
            recorridoDesc(nodo.izq, resultado);
        }
    }
}
