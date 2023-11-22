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
    
//A. Dado una secuencia de n-palabras ingresados. Mostrar la las palabras de menor a mayor por longitudes de palabras.
//Para resolver este problema, utilizar una Lista de ABB. Implementar los siguientes métodos:
//
//L1.palabrasAscAsc() : Método que muestra las palabras ordenados de menor a mayor por longitud de palabra de menor a mayor.
    public void palabrasAscAsc(){
        for(int i=0; i<max; i++){
            arbol[i].Asc();
        }
    }
    
//L1.palabrasAscDesc() : Método que muestra las palabras ordenados de menor a mayor por longitud de palabra de mayor a menor.
    public void palabrasAscDesc(){
        for(int i=max-1; i>0; i--){
            arbol[i].Asc();
        }
    }
    
//L1.palabrasDescAsc() : Método que muestra las palabras ordenados de mayor a menor por longitud de palabra de menor a mayor.
    public void palabrasDescAsc(){
        for(int i=0; i<max; i++){
            arbol[i].Desc();
        }
    }
    
//L1.palabrasDescDesc() : Método que muestra las palabras ordenados de mayor a menor por longitud de palabra de mayor a menor.
    public void palabrasDescDesc(){
        for(int i=max-1; i>0; i--){
            arbol[i].Desc();
        }
    }
  //---------------------Mismos métodos en String----------------------------
    public String palabrasAscAscString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < max; i++) {
            resultado.append(arbol[i].recorridoAsc());
        }
        return resultado.toString();
    }
    
    public String palabrasAscDescString() {
        StringBuilder resultado = new StringBuilder();
        for (int i=max-1; i>0; i--) {
            resultado.append(arbol[i].recorridoAsc());
        }
        return resultado.toString();
    }
    
    public String palabrasDescAscString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < max; i++) {
            resultado.append(arbol[i].recorridoDesc());
        }
        return resultado.toString();
    }
    
    public String palabrasDescDescString() {
        StringBuilder resultado = new StringBuilder();
        for (int i=max-1; i>0; i--) {
            resultado.append(arbol[i].recorridoDesc());
        }
        return resultado.toString();
    }
}
