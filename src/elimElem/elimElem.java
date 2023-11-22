/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package elimElem;

/**
 *
 * @author Alan
 */
public class elimElem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        arbol l1 = new arbol();
        l1.insertar(50);
        l1.insertar(30);
        l1.insertar(70);
        l1.insertar(20);
        l1.insertar(40);
        l1.insertar(60);
        l1.insertar(80);
        
        System.out.println("Arbol antes de eliminar: ");
        l1.inOrden();
        System.out.println("\n Arbol despues de eliminar");
        l1.eliminar(30);
        l1.inOrden();
    }
    
}
