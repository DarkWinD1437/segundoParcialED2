/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

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
    
    public void asc(){
        for(int i=0; i<max; i++){
            arbol[i].Asc();
        }
    }
    
    //1. Arbol de mayor altura
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
    
    //2. Igual tamaño, cantidad de elementos
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
    
    //3. L1.arbol Grande
    public Arbol arbolGrande() {
        Arbol arbolMasGrande = arbol[0]; 

        for (int i = 1; i < max; i++) {
            if (arbol[i].cantidad() > arbolMasGrande.cantidad()) {
                arbolMasGrande = arbol[i];
            }
        }

        return arbolMasGrande;
    }
    
    //4. Arbol que crece secuencialmente
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
    
    //5.misma altura
    public boolean mismaAltura() {
        int alturaReferencia = arbol[1].altura();
        System.out.println(1+" "+alturaReferencia);
        int i = 2;
        while(arbol[i].cantidad() != 0){
            int alturaActual = arbol[i].altura();
            System.out.println(i+" "+alturaActual);
            if (alturaReferencia != alturaActual) 
                return false;
            i++;
            alturaReferencia=alturaActual;
        }

        return true;
    }
}
