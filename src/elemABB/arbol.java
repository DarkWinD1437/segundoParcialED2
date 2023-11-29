/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elemABB;
import java.util.Random;

/**
 *
 * @author Alan
 */
public class arbol {
     public Nodo raiz;
     
     public arbol(){
         raiz = null;
     }
     /////////////////////////////////////////////////////
     public void insertar(int x){
         raiz = insertar(raiz, x);
     }
     
     private Nodo insertar(Nodo p, int x){
         if(p == null){
             return new Nodo(x);
         }
         if(x < p.elem){
             p.izq = insertar(p.izq, x);
         }
         else{
             p.der = insertar(p.der, x);
         }
         return p;
     }
     
     ///////////////////////////////////////////////////
     public void inOrden(){
         inOrden(raiz);
     }
     
     private void inOrden(Nodo p){
         if(p == null){
             return;
         }
         inOrden (p.izq);
         System.out.println(p.elem + " ");
         inOrden(p.der);
     }
     
     /////////////////////////////////////////////////////
     
     //1
     public void generarElem(int n,  int a, int b){
         Random rand = new Random();
         int range = b - a + 1;
         for(int i = 0; i < n; i++){
             int randomNum = rand.nextInt(range) + a;
             insertar(randomNum);
         }
     }
     
     //2
     public int suma(){
         return suma(raiz);
     }
     
     private int suma (Nodo p){
         if (p == null){
             return 0;
         }
         else{
             return suma(p.izq) + suma(p.der) + p.elem;
         }
     }
     
     //3
     public int calcularAltura(){
         return calcularAltura(raiz);
     }
     
     private int calcularAltura(Nodo p){
         if(p == null){
             return -1;
         }
         int alturaIzq = calcularAltura(p.izq);
         int alturaDer = calcularAltura(p.der);
         return Math.max(alturaIzq, alturaDer) + 1;
     }
     
     //4
     public int cantidadTerm(){
         return cantidadTerm(raiz);
     }
     
     private int cantidadTerm(Nodo p){
         if(p == null){
             return 0;
         }
         if(p.izq == null && p.der == null){
             return 1;
         }
         return cantidadTerm(p.izq) + cantidadTerm(p.der);
     }
     
     //5
     public boolean seEncuentra(int x){
         return seEncuentra(raiz, x);
     }
     
     private boolean seEncuentra(Nodo p, int x){
         if(p == null){
             return false;
         }
         if(p.elem == x){
             return true;
         }
         if(x < p.elem){
             return seEncuentra(p.izq, x);
         }
         else{
             return seEncuentra(p.der, x);
         }
     }
     
     //*
     public int cantidad(){
         return cantidad(raiz);
     }
     
     private int cantidad(Nodo p){
         if(p == null){
             return 0;
         }
         int izq = cantidad(p.izq);
         int der = cantidad(p.der);
         return izq + der + 1;
     }
     
     //*
     public int menor(){
         return menor(raiz);
     }
     
     private int menor(Nodo p){
         if(p.izq == null){
             return p.elem;
         }
         return menor(p.izq);
     }
}
