/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elimElem;

/**
 *
 * @author Alan
 */
public class arbol {
    public Nodo raiz;
    
    public arbol(){
        this.raiz =  null;
    }
   ////////////////////////////////////////////////////// 
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
    
    ////////////////////////////////////////////////////
    public void inOrden(){
        inOrden(raiz);
    }
    
    private void inOrden(Nodo p){
        if(p == null){
            return;
        }
        inOrden(p.izq);
        System.out.println(p.elem + " ");
        inOrden(p.der);
    }
    
    ////////////////////////////////////////////////////
    public Nodo eliminarNodo(Nodo p){
        if(p.izq == null && p.der == null){
            return null;
        }
        if(p.izq != null && p.der == null){
            return p.izq;
        }
        if(p.izq == null && p.der != null){
            return p.der;
        }
        int y = inmediatoSup(p.der);
        p.elem = y;
        p.der = eliminar(p.der, y);
        
        return p;
    }
    
    public int inmediatoSup(Nodo p){
        if(p.izq == null){
            return p.elem;
        }
        else{
            return inmediatoSup(p.izq);
        }
    }
    
    public void eliminar(int x){
        raiz = eliminar(raiz, x);
    }
    
    private Nodo eliminar(Nodo p, int x){
        if(p == null){
            return null;
        }
        if(x == p.elem){
            return eliminarNodo(p);
        }
        if(x < p.elem){
            p.izq = eliminar(p.izq, x);
        }
        else{
            p.der = eliminar(p.der, x);
        }
        return p;
    }
    
    /////////////////////////////////////////////////////
    //1
    
    public void eliminarPares(){
        raiz = eliminarPares(raiz);
    }
    
    private Nodo eliminarPares(Nodo p){
        if(p == null){
            return null;
        }
        p.izq = eliminarPares(p.izq);
        p.der = eliminarPares(p.der);
        if(p.elem % 2 == 0){
            if(p.izq != null){
                return p.izq;
            }
            else{
                return p.der;
            }
        }
        return p;
    }
    
    //2
    
    public void eliminarNiveles(int n){
        raiz = eliminarNiveles(raiz, n, 0);
    }
    
    private Nodo eliminarNiveles(Nodo p, int nivel, int nivelActual){
        if(p == null){
            return null;
        }
        if(nivel == nivelActual){
            return null;
        }
        p.izq = eliminarNiveles(p.izq, nivel, nivelActual+1);
        p.der = eliminarNiveles(p.der, nivel, nivelActual+1);
        return p;
    }
    
    //3
    
    public void eliminarRaices(){
        raiz = eliminarRaices(raiz);
    }
    
    private Nodo eliminarRaices(Nodo p){
        if(p == null){
            return null;
        }
        p.izq = eliminarRaices(p.izq);
        p.der = eliminarRaices(p.der);
        return null;
    }
    
    //4
    
    public void eliminarNodosUnHijo(){
        raiz = eliminarNodosUnHijo(raiz);
    }
    
    private Nodo eliminarNodosUnHijo(Nodo p){
        if(p == null){
            return null;
        }
        if(p.izq == null){
            return p.der;
        }
        if(p.der == null){
            return p.izq;
        }
        p.izq = eliminarNodosUnHijo(p.izq);
        p.der = eliminarNodosUnHijo(p.der);
        return p;
    }
    
    //5
    
    public void eliminarHojas(){
        eliminarHojas(raiz);
    }
    
    private void eliminarHojas(Nodo p){
        if(p != null){
            if(p.izq == null && p.der == null){
                eliminar(p.elem);
            }
            eliminarHojas(p.izq);
            eliminarHojas(p.der);
        }
    }
    
    //6
    public void eliminarEnNivel(int nivel){
        raiz = eliminarEnNivel(raiz, nivel);
    }
    
    private Nodo eliminarEnNivel(Nodo p, int nivel){
        if(p == null){
            return null;
        }
        if(nivel == 1){
            return null;
        }
        p.izq = eliminarEnNivel(p.izq, nivel-1);
        p.der = eliminarEnNivel(p.der, nivel-1);
        return p;
    }
    
    //7
    public void eliminarNodosDuplicados(){
        raiz = eliminarNodosDuplicados(raiz);
    }
    
    private Nodo eliminarNodosDuplicados(Nodo p){
        if(p == null){
            return null;
        }
        p.izq = eliminarNodosDuplicados(p.izq);
        p.der = eliminarNodosDuplicados(p.der);
        while(buscar(raiz, p.elem) > 1){
            raiz = eliminar(raiz, p.elem);
        }
        return p;
    }
    
    private int buscar(Nodo p, int x){
        if(p == null){
            return 0;
        }
        int contador = 0;
        if (p.elem == x) {
            contador++;
        }

        contador += buscar(p.izq, x);
        contador += buscar(p.der, x);

        return contador;
    }
    
}
