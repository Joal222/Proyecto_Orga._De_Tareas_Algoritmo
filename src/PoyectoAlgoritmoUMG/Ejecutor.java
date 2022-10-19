package PoyectoAlgoritmoUMG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Jose Avila (Joal)
 */
public class Ejecutor {
    public static void main(String[] args) {//main
        //01/10/2022 Inciando Proyecto.
        Scanner JA = new Scanner (System.in);
        
        //variables Globales
        int opc1 = 0, id= 1;
        String error = "Error, Porfavor Digite una opcion Valida";
        String nomTab="";
        //Creamos nuestro archivo
        File docum = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\tabs.txt");
       
        //nuestra referencia del objeto 
        Tablero tab;
        
        //Crear Vector para almacenar instancias de tipo tab
        Vector tableros = new Vector();
        
        do {
            System.out.println("1. Crear Tableros");
            System.out.println("2. Ver Lista de Tableros");
            System.out.println("3. Salir");
            opc1 = JA.nextInt();
            
            //Switch para los menus
            switch (opc1){
                case 1:
                    System.out.println("\n \n Ingrese el Nombre de su Tablero");
                    nomTab = JA.next();
                    try{
                        
                      //Crear instancias de nuestro objeto Tab.
                      tab = new Tablero(nomTab,id);
                      id++;
                      
                       //Cada ves que cree una istancia se añada en el vector
                       tableros.add(tab);
                       
                       //Escribir en nuestro Archivo. el FileOutput es para escribir objetos en el archivos
                       FileOutputStream flujo = new FileOutputStream(docum);
                       ObjectOutputStream escObj = new ObjectOutputStream(flujo);
                       
                       //escrib nuestro vector en nuestro archivo
                       escObj.writeObject(tableros);
                       System.out.println("El Tablero '" + nomTab + "' Se creo Exitosamente\n" );
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }                   
                    break;
                case 2:
                    try{
                        //leer archivo nuestro vector
                        FileInputStream flujoLeer = new FileInputStream (docum);
                        ObjectInputStream leerObj = new ObjectInputStream(flujoLeer);
                        //Castiiiing para hacer el cambio de un tipo de dato a otro
                        tableros=(Vector)leerObj.readObject();    
                        
                    }catch(FileNotFoundException e){
                        e.printStackTrace();

                    }catch(IOException e){
                        e.printStackTrace();

                    }catch(ClassNotFoundException e){
                        e.printStackTrace();
                        
                    }
                    
                    //iterator lee e imprime cada objeto de nuestro vector.
                    Iterator it = tableros.iterator();
                    //mientras el iterador encuentre objetos de tipo byte los escribira los objetos.
                    while (it.hasNext()){
                        tab=(Tablero)it.next();
                        System.out.println(tab.toString());
                        
                        
                    }   
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Adios :)");
                    opc1 = 2;
                    System.exit(0); 
                    break;
                default:
                    System.out.println(error);
                    
            }
            
        } while (opc1 != 3);
        
    }//main
}
