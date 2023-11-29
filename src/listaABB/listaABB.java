/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaABB;

/**
 *
 * @author Alan
 */
public class listaABB {
    public int max;
    public arbol listaABB[];
    ///////////////////////////////////////////////////
    public listaABB(int max){
        this.max=max;
        this.listaABB=new arbol[max];
        for(int i=0;i<max;i++){
            listaABB[i]=new arbol();
        }
    }
    
    ///////////////////////////////////////////////////
    public void insertar(String str){
        listaABB[str.length()].insertar(str);
    }
    
    ///////////////////////////////////////////////////
    public void inOrden(){
        for(int i=0;i<max;i++){
            listaABB[i].inOrden();
        }
    }
    
    ///////////////////////////////////////////////////
    //1 arbol de mayor altura
    
    public arbol arbolMayorAltura(){
        int maxAltura = -1;
        arbol arbolMayor = null;

        for (int i = 0; i < max; i++) {
            int alturaActual = listaABB[i].altura();
            if (alturaActual > maxAltura) {
                maxAltura = alturaActual;
                arbolMayor = listaABB[i];
            }
        }
        return arbolMayor;
    }
    
    //2 igual tamaño, cantidad de elementos
    
    public boolean igualTamaño() {
        int tamañoReferencia = -1;

        for (int i = 0; i < max; i++) {
            if (listaABB[i].raiz != null) {
                int tamañoActual = listaABB[i].cantidad();
                if (tamañoReferencia == -1) {
                    tamañoReferencia = tamañoActual;
                } else {
                    if (tamañoActual != tamañoReferencia) return false;  
                }
            }
        }
        return true; 
    }
    
    //3 l1.arbol grande
    
    public arbol arbolGrande() {
        arbol arbolMasGrande = listaABB[0]; 

        for (int i = 1; i < max; i++) {
            if (listaABB[i].cantidad() > arbolMasGrande.cantidad()) {
                arbolMasGrande = listaABB[i];
            }
        }
        return arbolMasGrande;
    }
    
    //4 arbol que crece secuencialmente
    
    public boolean arbolAsc() {
        int cantidadAnterior = listaABB[1].cantidad();
        int sec=listaABB[2].cantidad()-cantidadAnterior;
        int i = 2;
        while(listaABB[i].cantidad() != 0){
            int cantidadActual = listaABB[i].cantidad();
            if (cantidadActual - cantidadAnterior!=sec) return false;
            cantidadAnterior = listaABB[i].cantidad();
            i++;
        }
        return true;
    }
    
    //5 misma altura
    
    public boolean mismaAltura() {
        int alturaReferencia = listaABB[1].altura();
        System.out.println(1+" "+alturaReferencia);
        int i = 2;
        while(listaABB[i].cantidad() != 0){
            int alturaActual = listaABB[i].altura();
            System.out.println(i+" "+alturaActual);
            if (alturaReferencia != alturaActual) 
                return false;
            i++;
            alturaReferencia=alturaActual;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
