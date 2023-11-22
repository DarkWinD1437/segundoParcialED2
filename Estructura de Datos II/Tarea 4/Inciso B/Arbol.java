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
        raiz = insertar(raiz, str);
    }

    private Nodo insertar(Nodo p, String str) {
        if (p == null) return new Nodo(str);
        int comparacion = str.compareTo(p.str);
        if (comparacion == 0) {
            p.frec++;
        } else if (comparacion < 0) {
            p.izq = insertar(p.izq, str);
        } else {
            p.der = insertar(p.der, str);
        }

        return p;
    }  
    //-------------------------------------------------------------------------
    public void Asc(){
        Asc(raiz);
    }
    
    private void Asc(Nodo p){
        if (p==null) return;
        Asc(p.izq);
        System.out.println(p.str+", "+p.frec);
        Asc(p.der);
    }
    
    public void Desc(){
        Desc(raiz);
    }
    
    private void Desc(Nodo p){
        if (p==null) return;
        Desc(p.der);
        System.out.println(p.str+", "+p.frec);
        Desc(p.izq);
    }
    
    //------------------AscDescConString------------------------
    public String AscString(){
        StringBuilder resultado = new StringBuilder();
        AscString(raiz, resultado);
        return resultado.toString();
    }
    
    private void AscString(Nodo p, StringBuilder resultado){
        if (p!=null) {
            AscString(p.izq, resultado);
            resultado.append(p.str).append(" ").append(p.frec).append(", ");
            AscString(p.der, resultado);
        }
    }
    
    public String DescString(){
        StringBuilder resultado = new StringBuilder();
        DescString(raiz, resultado);
        return resultado.toString();
    }
    
    private void DescString(Nodo p, StringBuilder resultado){
        if (p!=null) {
            DescString(p.der, resultado);
            resultado.append(p.str).append(" ").append(p.frec).append(", ");
            DescString(p.izq, resultado);
        }
    }
    
    //-------------------------------------------------------------------------
    
    public boolean seEncuentra(String str) {
        return seEncuentra(raiz, str);
    }

    private boolean seEncuentra(Nodo nodo, String str) {
        if (nodo == null) {
            return false;  // Si llegamos a una hoja y no encontramos el elemento, retornamos false
        }

        int comparacion = str.compareTo(nodo.str);
        if (comparacion == 0) {
            return true;   // Encontramos la cadena en el nodo actual
        } else if (comparacion < 0) {
            return seEncuentra(nodo.izq, str);  // Buscamos en el subárbol izquierdo
        } else {
            return seEncuentra(nodo.der, str);  // Buscamos en el subárbol derecho
        }
    }
    
    //--------------------------------------------------------------------------
    
    public Nodo buscarNodo(String str) {
        return buscarNodoEnArbol(raiz, str);
    }

    private Nodo buscarNodoEnArbol(Nodo nodo, String str) {
        if (nodo == null) {
            return null;  // Si llegamos a una hoja y no encontramos el elemento, retornamos null
        }

        int comparacion = str.compareTo(nodo.str);
        if (comparacion == 0) {
            return nodo;  // Encontramos la cadena en el nodo actual, devolvemos el nodo
        } else if (comparacion < 0) {
            return buscarNodoEnArbol(nodo.izq, str);  // Buscamos en el subárbol izquierdo
        } else {
            return buscarNodoEnArbol(nodo.der, str);  // Buscamos en el subárbol derecho
        }
    }
    
    //---------------------------------------------------------------------
    
    public void eliminarNodo(Nodo nodoEliminar) {
        if (nodoEliminar == null) {
            return;  // No hay nada que eliminar
        }

        raiz = eliminarNodoRecursivo(raiz, nodoEliminar);
    }

    private Nodo eliminarNodoRecursivo(Nodo actual, Nodo nodoEliminar) {
        if (actual == null) {
            return null;  // Llegamos a una hoja, no encontramos el nodo a eliminar
        }

        int comparacion = nodoEliminar.str.compareTo(actual.str);
        if (comparacion < 0) {
            actual.izq = eliminarNodoRecursivo(actual.izq, nodoEliminar);
        } else if (comparacion > 0) {
            actual.der = eliminarNodoRecursivo(actual.der, nodoEliminar);
        } else {
            // Encontramos el nodo a eliminar
            actual = realizarEliminacion(actual);
        }

        return actual;
    }

    private Nodo realizarEliminacion(Nodo nodoEliminar) {
        if (nodoEliminar.izq == null) {
            return nodoEliminar.der;  // Nodo con un solo hijo o sin hijos
        } else if (nodoEliminar.der == null) {
            return nodoEliminar.izq;  // Nodo con un solo hijo (izquierdo)
        } else {
            // Nodo con dos hijos, encontrar sucesor inorden
            Nodo sucesor = obtenerNodoSucesor(nodoEliminar);
            nodoEliminar.str = sucesor.str;
            nodoEliminar.frec = sucesor.frec;
            nodoEliminar.der = eliminarNodoRecursivo(nodoEliminar.der, sucesor);
            return nodoEliminar;
        }
    }

    private Nodo obtenerNodoSucesor(Nodo nodo) {
        Nodo sucesor = nodo.der;
        while (sucesor.izq != null) {
            sucesor = sucesor.izq;
        }
        return sucesor;
    }
}
