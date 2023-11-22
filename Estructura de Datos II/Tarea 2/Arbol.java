/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolconlibrerialista;
import java.util.*;
/**
 *
 * @author SARA EUNICE
 */
public class Arbol {
    public Nodo raiz;
    
    public Arbol() {
        raiz=null;
    }
    
    //-❁-❁-❁-❁-Tarea-2, Viernes 27 de octubre-❁-❁-❁-❁-//
    
//1. A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros
//diferentes entre a y b inclusive.
    public void generarElem(int n, int a, int b) {
        int at;
        for (int i=1; i<=n; i++) {
            at= (int) (Math.random()*((b+1)-a)+a);
            insertar(at);
        }
    }
    
//2. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar
//correspondiente.
    public void insertar(int x) {
        raiz=insertar(raiz,x);
    }
    
    private Nodo insertar(Nodo p, int x) {
        if (p==null) return new Nodo(x);
        if (x<p.elem)
            p.izq= insertar(p.izq,x);
        else
            p.der=insertar(p.der,x);
        return p;
    }
    
//3. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preOrden(){
        preOrden(raiz);
    }
    
    private void preOrden(Nodo p){
        if (p==null) return;
        System.out.println(p.elem);
        preOrden(p.izq);
        preOrden(p.der);
    }
    
//4. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void inOrden(){
        inOrden(raiz);
    }
    
    private void inOrden(Nodo p){
        if (p==null) return;
        inOrden(p.izq);
        System.out.println(p.elem);
        inOrden(p.der);
    }
    
//5. A1.postOrden() : Método que muestra los elementos del árbol A1 en
//postOrden.
    public void postOrden(){
        postOrden(raiz);
    }
    
    private void postOrden(Nodo p){
        if (p==null) return;
        postOrden(p.izq);
        postOrden(p.der);
        System.out.println(p.elem);
    }
    
//6. A1.niveles(): Método que muestra los elementos del árbol A1, por niveles.
    public void niveles(){
    LinkedList<Nodo> L1 = new LinkedList();
        L1.add(raiz);
        while(!L1.isEmpty()){
            Nodo q = L1.getFirst();
            if(q.izq != null) L1.add(q.izq);
            if(q.der != null) L1.add(q.der);
            L1.removeFirst();
            System.out.println(q.elem);
        }
    }
  
//7. A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    public void desc() {
        desc(raiz);
    }
    
    private void desc(Nodo p){
        if (p==null) return;
        desc(p.der);
        System.out.println(p.elem);
        desc(p.izq);
        
    }
    
//8. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se
//encuentra en el árbol A1.
    public boolean seEncuentra(int x) {
        return seEncuentra(raiz, x);
    }
    
    private boolean seEncuentra(Nodo p, int x) {
        if (p==null) return false;
        if (x==p.elem) return true;
        if (x<p.elem) 
            return seEncuentra(p.izq,x);
        else
            return seEncuentra(p.der,x);
    }
    
//9. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad() {
        return cantidad(raiz);
    }
    
    private int cantidad(Nodo p){
        if (p==null) return 0;
        return 1+cantidad(p.izq)+cantidad(p.der);
    }
    
//10. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma(){
        return suma(raiz);
    }
    
    private int suma(Nodo p){
        if (p==null) return 0;
        return p.elem+suma(p.der)+suma(p.izq);
    }
    
//11. A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor(){
        return menor(raiz);
    }
    
    private int menor(Nodo p){
        if (p.izq==null) return p.elem;
        return menor(p.izq);
    }
    
//12. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor(){
        return mayor(raiz);
    }
    
    private int mayor(Nodo p){
        if (p.der==null) return p.elem;
        return mayor(p.der);
    }
    
//13. A1.preoOrden(L1) : Método que encuentra en la lista L1, el recorrido de
//preOrden de los elementos del árbol A1.
    public void preOrden(LinkedList<Integer> L1){
        preOrden(L1, raiz);
    }

    private void preOrden(LinkedList<Integer> L1, Nodo p){
        if(p == null) return;
        L1.add(p.elem);
        preOrden(L1, p.izq);
        preOrden(L1, p.der);
    }
    
//14. A1.inOrden(L1) : Método que encuentra en la lista L1, el recorrido de inOrden
//de los elementos del árbol A1.
    public void inOrden(LinkedList<Integer> L1){
        inOrden(L1, raiz);
    }

    private void inOrden(LinkedList<Integer> L1, Nodo p){
        if(p == null) return;
        inOrden(L1, p.izq);
        L1.add(p.elem);
        inOrden(L1, p.der);
    }
    
//15. A1.postOrden(L1) : Método que encuentra en la lista L1, el recorrido de
//postOrden de los elementos del árbol A1.
    public void postOrden(LinkedList<Integer> L1){
        postOrden(L1, raiz);
    }

    private void postOrden(LinkedList<Integer> L1, Nodo p){
        if(p == null) return;
        postOrden(L1, p.izq);
        postOrden(L1, p.der);
        L1.add(p.elem);
    }
    
//16. A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por niveles
//de los elementos del árbol A1.
    public void niveles(LinkedList<Integer> L2){
        mostrarNiveles(L2);
    }
    
    private void mostrarNiveles(LinkedList<Integer> L2){
    LinkedList<Nodo> L1 = new LinkedList();
        L1.add(raiz);
        while(!L1.isEmpty()){
            Nodo q = L1.getFirst();
            if(q.izq != null) L1.add(q.izq);
            if(q.der != null) L1.add(q.der);
            L1.removeFirst();
            L2.add(q.elem);
        }
    }
    
//17. A1.mostrarAsc(): Método que muestra los elementos del árbol de menor a
//mayor y junto a cada elemento mostrar el nivel en el que se encuentra dicho
//elemento.
    public void mostrarAsc() {
        mostrarAsc(raiz, 0);
    }

    private void mostrarAsc(Nodo p, int nivel) {
    if (p != null) {
        // Recorrer el subárbol izquierdo
        mostrarAsc(p.izq, nivel + 1);

        // Mostrar el elemento y su nivel
        System.out.println("Elemento: " + p.elem + ", Nivel: " + nivel);

        // Recorrer el subárbol derecho
        mostrarAsc(p.der, nivel +1);
    }
}

//18. A1.sumarNivel(L1) : Método que encuentra en la Lista L1, la suma de los
//elementos de cada nivel. Sugerencia, utilizar una Lista dónde cada elemento de la
//lista de la posición-i, sea un acumulador del nivel-i.
    public void sumarNivel(LinkedList<Integer> L1) {
        Queue<Nodo> queue = new LinkedList<>(); // Cola para realizar un recorrido por niveles

        if (raiz == null) {
            return; // El árbol está vacío, no hay nada que hacer
        }

        queue.offer(raiz); // Agregar la raíz a la cola

        while (!queue.isEmpty()) {
            int nivelSize = queue.size();
            int nivelSum = 0;

            for (int i = 0; i < nivelSize; i++) {
                Nodo p = queue.poll();
                nivelSum += p.elem;

                if (p.izq != null) {
                    queue.offer(p.izq);
                }

                if (p.der != null) {
                    queue.offer(p.der);
                }
            }

            L1.add(nivelSum); // Agregar la suma del nivel actual a la lista L1
        }
    }

//19. A1.alturaMayor(): Método que devuelve la altura del árbol A1. (Altura es la
//máxima longitud de la raíz a un nodo hoja en el árbol)
    public int alturaMayor() {
        return alturaMayor(raiz);
    }

    private int alturaMayor(Nodo p) {
        if (p == null) {
            return -1; // Altura de un árbol vacío es -1
        }

        int alturaIzquierda = alturaMayor(p.izq);
        int alturaDerecha = alturaMayor(p.der);

        // La altura del árbol es la máxima entre la altura izquierda y la altura derecha más 1 (para incluir el nodo actual)
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }
    
//20. A1.alturaMenor(): Método que devuelve la menor altura del árbol A1.
    public int alturaMenor() {
        return alturaMenor(raiz);
    }

    private int alturaMenor(Nodo p) {
        if (p == null) {
            return -1; // Altura de un árbol vacío es -1
        }

        if (p.izq == null && p.der == null) {
            return 0; // Es un nodo hoja, su altura es 0
        }

        int alturaIzquierda = alturaMenor(p.izq);
        int alturaDerecha = alturaMenor(p.der);

        // La altura menor del árbol es la mínima entre la altura izquierda y la altura derecha más 1 (para incluir el nodo actual)
        return Math.min(alturaIzquierda, alturaDerecha) + 1;
    }

//21. A1.mostrarTerm(): Método que muestra los elementos de los nodos
//terminales del árbol A1. Mostrar los elementos de menor a mayor.
    public void mostrarTerm(){
        mostrarTerm(raiz);
    }
    
    private void mostrarTerm(Nodo p) {
        if (p == null) return;
        if (p.izq == null &&  p.der == null){
            System.out.println(p.elem+" ");
            return;
        }
        if (p.izq != null)  
            mostrarTerm(p.izq);    
        if (p.der != null)  
            mostrarTerm(p.der);
    }
//22. A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales
//del árbol A1.
    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }
    
    private int cantidadTerm(Nodo p) {
        if (p == null) return 0;
        if (p.izq == null &&  p.der == null){
            return 1;
        }
        int izq= cantidadTerm(p.izq);
        int der= cantidadTerm(p.der);
        return izq+der;
    }
    
//23. A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol
//degenerado o lineal. (Se puede dar cuando se genera el árbol con una secuencia
//ordenada de elementos)
    public boolean lineal() {
        return lineal(raiz);
    }

    private boolean lineal(Nodo p) {
        if (p == null) {
            return true; // Un árbol vacío se considera degenerado
        }

        if (p.izq != null && p.der != null) {
            return false; // Si un nodo tiene dos hijos, no es degenerado
        }

        // Verificar recursivamente los subárboles izquierdo y derecho
        return lineal(p.izq) && lineal(p.der);
    }
    
//24. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a
//x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoSup(int x) {
        return inmediatoSup(raiz, x);
    }

    private int inmediatoSup(Nodo p, int x) {
        if (p.elem==x){
            if (p.der!=null)
                return p.der.elem;
            else
                return x;
        }
        if (x<p.elem)
            return inmediatoSup(p.izq,x);
        else
            return inmediatoSup(p.der,x);
    }
    
//25. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x,
//si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoInf(int x) {
        return inmediatoInf(raiz, x);
    }

    private int inmediatoInf(Nodo p, int x) {
        if (p.elem==x){
            if (p.izq!=null)
                return p.izq.elem;
            else
                return x;
        }
        if (x<p.elem)
            return inmediatoInf(p.izq,x);
        else
            return inmediatoInf(p.der,x);
    }
//26. Implementar al menos 5 Ejercicios adicionales cualesquiera, de consultas sobre
//uno o más árboles binarios de búsqueda. Citar fuentes.
    //1. Invertir arbol. Fuente: https://www.youtube.com/watch?v=OnSn2XEQ4MY&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=3
        public Nodo invertTree(){
            return invertTree(raiz);
        }

        public Nodo invertTree(Nodo p){
             if (p==null)
                 return null;
            Nodo tmp=p.izq;
            p.izq = p.der;
            p.der = tmp;
            invertTree(p.izq);
            invertTree(p.der);
            return p;
        }
    
    //2. ¿arboles iguales?. Fuente: https://www.youtube.com/watch?v=vRbbcKXCxOw&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=17
        public boolean isSameTree(Arbol a2){
            return isSameTree(raiz, a2.raiz);
        }
        
        private boolean isSameTree(Nodo p, Nodo q){
            if ((p==null) && (q==null))
                return true;
            if ((p==null) || (q==null) || (p.elem!=q.elem))
                return false;
            return (isSameTree(p.izq, q.izq) && isSameTree(p.der, q.der));
        }
        
}
