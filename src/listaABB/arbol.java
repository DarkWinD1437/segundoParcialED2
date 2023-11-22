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
        this.raiz = raiz;
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
    public void inOrdenDesc() {
        inOrdenDesc(raiz);
    }

    private void inOrdenDesc(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenDesc(p.der); 
        System.out.println(p.str);
        inOrdenDesc(p.izq);  
    }
    ////////////////////////////////////////////////
    
    
}
