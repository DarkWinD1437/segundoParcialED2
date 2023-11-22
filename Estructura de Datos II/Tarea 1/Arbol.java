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
    
    //-❁-❁-❁-❁-Tarea-1, Sabado 21 de octubre-❁-❁-❁-❁-//
//1.  A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros diferentes entre a y b inclusive.
    public void generarElem(int n, int a, int b) {
        int at;
        for (int i=1; i<=n; i++) {
            at= (int) (Math.random()*((b+1)-a)+a);
            insertar(at);
        }
    }
    
//2.  A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
    public void insertar(int x) {
        raiz=insertar(raiz,x);
    }
    
    private Nodo insertar(Nodo p, int x) {
        if (p==null) return new Nodo(x);
        if (x<p.elem)
            p.izq= insertar(p.izq,x);
        else
            p.der=insertar(p.der,x);
        return p;
    }
    
//3.  A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preOrden(){
        preOrden(raiz);
    }
    
    private void preOrden(Nodo p){
        if (p==null) return;
        System.out.println(p.elem);
        preOrden(p.izq);
        preOrden(p.der);
    }
    
//4.  A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void inOrden(){
        inOrden(raiz);
    }
    
    private void inOrden(Nodo p){
        if (p==null) return;
        inOrden(p.izq);
        System.out.println(p.elem);
        inOrden(p.der);
    }
    
//5.  A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    public void postOrden(){
        postOrden(raiz);
    }
    
    private void postOrden(Nodo p){
        if (p==null) return;
        postOrden(p.izq);
        postOrden(p.der);
        System.out.println(p.elem);
    }
    
//6.  A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    public void desc() {
        desc(raiz);
    }
    
    private void desc(Nodo p){
        if (p==null) return;
        desc(p.der);
        System.out.println(p.elem);
        desc(p.izq);
        
    }
//7.  A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    public boolean seEncuentra(int x) {
        return seEncuentra(raiz, x);
    }
    
    private boolean seEncuentra(Nodo p, int x) {
        if (p==null) return false;
        if (p.elem==x)
            return true;
        if (x < p.elem) {
            return seEncuentra(p.izq, x);
        } else {
            return seEncuentra(p.der, x);
        }
    }
    
//8.  A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad() {
        return cantidad(raiz);
    }
    
    private int cantidad(Nodo p){
        if (p==null) return 0;
        return 1+cantidad(p.izq)+cantidad(p.der);
    }
    
//9.  A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma(){
        return suma(raiz);
    }
    
    private int suma(Nodo p){
        if (p==null) return 0;
        return p.elem+suma(p.der)+suma(p.izq);
    }
    
//10.  A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor(){
        return menor(raiz);
    }
    
    private int menor(Nodo p){
        if (p.izq==null) return p.elem;
        return menor(p.izq);
    }
    
//11.  A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor(){
        return mayor(raiz);
    }
    
    private int mayor(Nodo p){
        if (p.der==null) return p.elem;
        return mayor(p.der);
    }
    
//12.  A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
    public void mostrarTerm(){
        mostrarTerm(raiz);
    }
    
    private void mostrarTerm(Nodo p) {
        if (p == null) return;
        if (p.izq == null &&  p.der == null){
            System.out.println(p.elem+" ");
            return;
        }
        if (p.izq != null)  
            mostrarTerm(p.izq);    
        if (p.der != null)  
            mostrarTerm(p.der);
    }
    
//13.  A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales del árbol A1.
    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }
    
    private int cantidadTerm(Nodo p) {
        if (p == null) return 0;
        if (p.izq == null &&  p.der == null){
            return 1;
        }
        int izq= cantidadTerm(p.izq);
        int der= cantidadTerm(p.der);
        return izq+der;
    }
//14.  A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lIneal. (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)
    public boolean lineal() {
        return lineal(raiz);
    }

    private boolean lineal(Nodo p) {
        if (p == null) {
            return true; // Un árbol vacío se considera degenerado
        }

        if (p.izq != null && p.der != null) {
            return false; // Si un nodo tiene dos hijos, no es degenerado
        }

        // Verificar recursivamente los subárboles izquierdo y derecho
        return lineal(p.izq) && lineal(p.der);
    }

//15. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoSup(int x) {
        return inmediatoSup(raiz, x);
    }

    private int inmediatoSup(Nodo p, int x) {
        if (p.elem==x){
            if (p.der!=null)
                return p.der.elem;
            else
                return x;
        }
        if (x<p.elem)
            return inmediatoSup(p.izq,x);
        else
            return inmediatoSup(p.der,x);
    }
 
//16. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoInf(int x) {
        return inmediatoInf(raiz, x);
    }

    private int inmediatoInf(Nodo p, int x) {
        if (p.elem==x){
            if (p.izq!=null)
                return p.izq.elem;
            else
                return x;
        }
        if (x<p.elem)
            return inmediatoInf(p.izq,x);
        else
            return inmediatoInf(p.der,x);
    }
    
//17.  Implementar al menos 5 Ejercicios adicionales cualesquiera, de consultas sobre uno o más árboles binarios de búsqueda. Citar fuentes.
}
