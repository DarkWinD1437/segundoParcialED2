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
        boolean b=false;
        Nodo p=null;
        Nodo op=null;
        int i=1;
        while (b==false && i<max) {
            b=arbol[i].seEncuentra(str);
            i++;
        }
        if (b==true) {
            p=arbol[i-1].buscarNodo(str);
            int n=p.frec;
            for (int j=1; j<=n+1; j++) {
                arbol[n+1].insertar(str);
            }
            arbol[n].eliminarNodo(p);
        } else {
            arbol[1].insertar(str);
        }
    }
    //B. Dado una secuencia de n-palabras. Encontrar la frecuencia de cada palabra.
//Mostrar las palabras por frecuencia, ordenados de menor a mayor. Sugerencia, utilizar una Lista de ABB, la posición de la lista representa la frecuencia.
//A1.menorMayor() : Método que muestra las palabras de menor a mayor con sus respectivas frecuencias.
    public void menorMayor(){
        for(int i=0; i<max; i++){
            arbol[i].Asc();
        }
    }
    
//A1.mayorMenor(): Método que muestra las palabras de mayor a menor con sus respectivas frecuencias.
    public void mayorMenor(){
        for(int i=0; i<max; i++){
            arbol[i].Desc();
        }
    }
    
//------------------Mismos métodos con String-------------------
    public String menorMayorString(){
        StringBuilder resultado = new StringBuilder();
        for(int i=0; i<max; i++){
            resultado.append(arbol[i].AscString());
        }
        return resultado.toString();
    }
    
    public String mayorMenorString(){
        StringBuilder resultado = new StringBuilder();
        for(int i=0; i<max; i++){
            resultado.append(arbol[i].DescString());
        }
        return resultado.toString();
    }
}
