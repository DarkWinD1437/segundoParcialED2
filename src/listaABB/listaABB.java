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
    public listaABB(int max) {
        this.max = max;
        this.listaABB = new arbol[max];
        for (int i = 0; i < max; i++) {
            listaABB[i] = new arbol();
        }
    }

    ///////////////////////////////////////////////////
    public void insertar(String str) {
        listaABB[str.length()].insertar(str);
    }

    ///////////////////////////////////////////////////
    public void inOrden() {
        for (int i = 0; i < max; i++) {
            listaABB[i].inOrden();
        }
    }

    ///////////////////////////////////////////////////
    //1 arbol de mayor altura
    public arbol arbolMayorAltura() {
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
                    if (tamañoActual != tamañoReferencia) {
                        return false;
                    }
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
        int sec = listaABB[2].cantidad() - cantidadAnterior;
        int i = 2;
        while (listaABB[i].cantidad() != 0) {
            int cantidadActual = listaABB[i].cantidad();
            if (cantidadActual - cantidadAnterior != sec) {
                return false;
            }
            cantidadAnterior = listaABB[i].cantidad();
            i++;
        }
        return true;
    }

    //5 misma altura
    public boolean mismaAltura() {
        int alturaReferencia = listaABB[1].altura();
        int i = 2;
        while (listaABB[i].cantidad() != 0) {
            int alturaActual = listaABB[i].altura();
            if (alturaReferencia != alturaActual) {
                return false;
            }
            i++;
            alturaReferencia = alturaActual;
        }
        return true;
    }

    public static void main(String[] args) {

        listaABB l1 = new listaABB(20);

        l1.insertar("hola");
        l1.insertar("mundo");

        l1.insertar("gato");
        l1.insertar("perro");
        l1.insertar("pájaro");

        l1.insertar("uno");
        l1.insertar("dos");
        l1.insertar("tres");
        l1.insertar("cuatro");
        
//1
        System.out.println("\n1");
        arbol arbolMayorAltura = l1.arbolMayorAltura();

        if (arbolMayorAltura != null) {
            System.out.println("El arbol con mayor altura tiene altura " + arbolMayorAltura.altura() + ".");
        } else {
            System.out.println("No hay arboles en la lista.");
        }

//2
        System.out.println("\n2");
        boolean sonIguales = l1.igualTamaño();

        if (sonIguales) {
            System.out.println("Los arboles tienen el mismo tamaño.");
        } else {
            System.out.println("Los arboles NO tienen el mismo tamaño.");
        }

//3
        System.out.println("\n3");
        arbol arbolMasGrande = l1.arbolGrande();

        if (arbolMasGrande != null) {
            System.out.println("El arbol mas grande tiene " + arbolMasGrande.cantidad() + " nodos.");
        } else {
            System.out.println("No hay arboles en la lista.");
        }

//4
        System.out.println("\n4");
        boolean esAscendente = l1.arbolAsc();

        if (esAscendente) {
            System.out.println("La cantidad de nodos en los arboles sigue una secuencia ascendente.");
        } else {
            System.out.println("La cantidad de nodos en los arboles NO sigue una secuencia ascendente.");
        }
        
//5
        System.out.println("\n5");
        boolean tienenMismaAltura = l1.mismaAltura();

        if (tienenMismaAltura) {
            System.out.println("Los arboles tienen la misma altura.");
        } else {
            System.out.println("Los arboles NO tienen la misma altura.");
        }
    }
}
