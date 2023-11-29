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
    //1
    public void palabrasAscAsc() {
        for(int i = 0; i < max; i++){
            listaABB[i].inOrden();
        }
    }
    
    //2
    public void palabrasAscDesc() {
        for(int i = max - 1; i >= 0; i--){
            listaABB[i].inOrden();
        }
    }
    
    //3
    public void palabrasDescAsc() {
        for(int i = 0; i < max; i++){
            listaABB[i].inOrdenDesc();
        }
    }
    
    //4
    public void palabrasDescDesc() {
        for(int i = max - 1; i >= 0; i--){
            listaABB[i].inOrdenDesc();
        }
    }
    
    //5
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
