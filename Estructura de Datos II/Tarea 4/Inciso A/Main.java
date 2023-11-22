/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author SARA EUNICE
 */
public class Main {

    public static void main(String[] args) throws IOException{
        ListaArbol L1= new ListaArbol(20);
        
        //Leer el archivo de texto
        FileReader archivo;
        BufferedReader lector;
        
        try{
            archivo = new FileReader("C:\\Sara\\Universidad\\Estructura de datos ii\\Tareas Código\\Arboles\\Tarea-4\\main\\src\\main\\java\\com\\mycompany\\main\\archivo1.txt");
            lector = new BufferedReader(archivo);
            String cadena;
            while ((cadena = lector.readLine())!=null){
                //Ciclo para capturar y eliminar la primera palabra luego ir insertando
                // Dividir la cadena en palabras usando split
                String[] palabras = cadena.split("\\s+");

                // Insertar cada palabra en la ListaArbol
                for (String palabra : palabras) {
                    palabra = palabra.replaceAll("[-,;:.1'234567890(){}|¿?]", "");

                    if (!palabra.isEmpty()) {
//                        System.out.println(palabra);
                        L1.insertar(palabra);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        //--------------------------------------------------------------------------------
        
        //Escribir en un archivo
        FileWriter archivo2=null;
        PrintWriter escritor=null;
        
        try{
            archivo2=new FileWriter("C:\\Sara\\Universidad\\Estructura de datos ii\\Tareas Código\\Arboles\\Tarea-4\\main\\src\\main\\java\\com\\mycompany\\main\\archivo2.txt");
            escritor = new PrintWriter(archivo2);
            escritor.print(L1.palabrasDescDescString());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            archivo2.close();
        }
        
        //--------------------------------------------------------------------------------
        L1.palabrasDescDesc();
    }
}
