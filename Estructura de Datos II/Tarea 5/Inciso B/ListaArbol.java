/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.ArrayList;

/**
 *
 * @author SARA EUNICE
 */
public class ListaArbol {
    public int max;
    public Arbol arbol[];
    
    public ListaArbol(int max){
        this.max=max;
        this.arbol=new Arbol[max];
        
        for (int i=0; i<max; i++)
            arbol[i]=new Arbol();
    }
    
    public void insertar(String str){
        arbol[str.length()].insertar(str);
    }
    
    public void eliminar(String str) {
        for (int i = 0; i < max; i++) {
            arbol[i].eliminar(str);
        }
    }
    
    //1. L1.eliminar(L2): Método que elimina las palabras que aparecen en L2, de los árboles de L1. L2, puede contener por ejemplo artículos or preposiciones or conectivos, etc.
    
    public void eliminar(ArrayList<String> palabrasAEliminar) {
        for (int i = 0; i < max; i++) {
            for (String palabra : palabrasAEliminar) {
                arbol[i].raiz = eliminarPalabra(arbol[i].raiz, palabra);
            }
        }
    }

    private Nodo eliminarPalabra(Nodo p, String palabraAEliminar) {
        if (p == null) {
            return null;
        }

        // Eliminar palabra en subárbol izquierdo y derecho
        p.izq = eliminarPalabra(p.izq, palabraAEliminar);
        p.der = eliminarPalabra(p.der, palabraAEliminar);

        // Eliminar nodo actual si es igual a la palabra a eliminar
        if (p.str.equals(palabraAEliminar)) {
            return eliminarNodo(p);
        }

        return p;
    }

    private Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        Nodo q = p.der;
        while (q.izq != null) {
            q = q.izq;
        }
        q.izq = p.izq;
        return p.der;
    }
    
    //2. L1.eliminarNodosRaices() : Método que elimina los nodos principales raíz, de cada Arbol.
    public void eliminarNodosRaices() {
        for (int i = 0; i < max; i++) {
            arbol[i].eliminarRaiz();
        }
    }
    
    //3. L1.eliminarNodosTerm() : Método que elimina los nodos terminales de cada Arbol de L1.
    public void eliminarNodosTerm() {
        for (int i = 0; i < max; i++) {
            arbol[i].eliminarHojas();
        }
    }
    
    //4. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
    //-----------------------------------------------------
    

    
//Métodos de mostrar
    public void palabrasAscAsc(){
        for(int i=0; i<max; i++){
            arbol[i].Asc();
        }
    }
    
    public void palabrasAscDesc(){
        for(int i=max-1; i>0; i--){
            arbol[i].Asc();
        }
    }
    
    public void palabrasDescAsc(){
        for(int i=0; i<max; i++){
            arbol[i].Desc();
        }
    }
    
    public void palabrasDescDesc(){
        for(int i=max-1; i>0; i--){
            arbol[i].Desc();
        }
    }
    
//CONSULTAS.
    //1. L1.arbolPequeño() : Método que devuelve el Árbol de menos cantidad de elementos.
    public Arbol arbolPequeno() {
        int minCantidad = Integer.MAX_VALUE;
        Arbol arbolMasPequeno = null;

        for (int i = 0; i < max; i++) {
            Arbol arbolActual = arbol[i];
            int cantidadActual = arbolActual.cantidad();

            if (cantidadActual < minCantidad && cantidadActual > 0) {
                minCantidad = cantidadActual;
                arbolMasPequeno = arbolActual;
            }
        }
        return arbolMasPequeno;
    }
    
    //2. L1.arbolGrande() : Método que devuelve el Árbol de mayor cantidad de elementos.
    public Arbol arbolGrande() {
        Arbol arbolMasGrande = arbol[0]; 

        for (int i = 1; i < max; i++) {
            if (arbol[i].cantidad() > arbolMasGrande.cantidad()) {
                arbolMasGrande = arbol[i];
            }
        }

        return arbolMasGrande;
    }
    
    //3. L1.igualTamaño() : Método lógico que devuelve True, si todos los Arboles tiene la misma cantidad de elementos.
    public boolean igualTamaño() {
        int tamañoReferencia = -1;

        for (int i = 0; i < max; i++) {
            if (arbol[i].raiz != null) {
                int tamañoActual = arbol[i].cantidad();
                if (tamañoReferencia == -1) {
                    tamañoReferencia = tamañoActual;
                } else {
                    if (tamañoActual != tamañoReferencia) return false;  
                }
            }
        }

        return true; 
    }
    
    //4. L1.arbolAsc() : Método Lógico que devuelve True, si los árboles crecen secuencialmente por cantidad de elementos.
    public boolean arbolAsc() {
        int cantidadAnterior = arbol[1].cantidad();
        int sec=arbol[2].cantidad()-cantidadAnterior;
        int i = 2;
        while(arbol[i].cantidad() != 0){
            int cantidadActual = arbol[i].cantidad();
            if (cantidadActual - cantidadAnterior!=sec) return false;
            cantidadAnterior = arbol[i].cantidad();
            i++;
        }
        return true;
    }
    
    //5. L1.arbolMayorAltura() : Método que devuelve el arbol de mayor altura. 
    public Arbol arbolMayorAltura() {
        int maxAltura = -1;
        Arbol arbolMayor = null;

        for (int i = 0; i < max; i++) {
            int alturaActual = arbol[i].altura();
            if (alturaActual > maxAltura) {
                maxAltura = alturaActual;
                arbolMayor = arbol[i];
            }
        }

        return arbolMayor;
    }
    
    //6. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
}
