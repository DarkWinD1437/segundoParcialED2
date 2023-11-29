/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaABB;

/**
 *
 * @author Alan
 */
public class arbol {
    public Nodo raiz;

    public arbol() {
        raiz = null;
    }
    //////////////////////////////////////////////////
    public void insertar(String str) {
        raiz = insertar(raiz, str);
    }

    public Nodo insertar(Nodo p, String str) {
        if (p == null) {
            return new Nodo(str);
        }
        if (str.compareTo(p.str) < 0) {
            p.izq = insertar(p.izq, str);
        } else {
            p.der = insertar(p.der, str);
        }
        return p;
    }
    //////////////////////////////////////////////////
    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(Nodo p) {
        if (p == null) {
            return;
        }
        inOrden(p.izq);
        System.out.println(p.str);
        inOrden(p.der);
    }
    /////////////////////////////////////////////////
    
    public int altura(){
        return altura(raiz);
    }
    
    private int altura(Nodo p){
        if(p == null){
            return 0;
        }
        int altIzq = altura(p.izq);
        int altDer = altura(p.der);
        return 1 + Math.max(altIzq, altDer);
    }
    
    ///////////////////////////////////////////////////
    
    public int cantidad(){
        return cantidad(raiz);
    }
    
    public int cantidad(Nodo p){
        if(p == null){
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }
    
    //////////////////////////////////////////////////////////
}
