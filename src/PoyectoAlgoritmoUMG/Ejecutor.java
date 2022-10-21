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
        int opc1 = 0;//opc de administrador
        int id= 1;
        int contador = 1; 
        int opc3 = 0;
        int opc4 = 0;//opc de opciones del tablero
        String opc5 = " ";//opcion de eliminar un tablero
        String error = "Error, Porfavor Digite una opcion Valida";
        String nomTab="";
        String opc2 = " ";
        
        //Creamos nuestro archivo
        File docum = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\tabs.txt");
       
        //nuestra referencia del objeto 
        Tablero tab;
        
        //Crear Vector para almacenar instancias de tipo tab
        Vector tableros = new Vector();
        
        do {
            System.out.println("--------------------------------");
            System.out.println("| "+"Bienvenido A Su Organizador "+" |");
            System.out.println("| "+"-------- De Tareas --------"+"  |");
            System.out.println("| " + "1. Ver Lista de Tableros"+"     |");
            System.out.println("| "+"2. Crear Tableros"+"            |");
            System.out.println("| "+ "3. Salir"+"                     |");
            System.out.println("--------------------------------");
            System.out.println("Que Desea Realizar?");
            opc1 = JA.nextInt();
            System.out.println(" ");
            
            //Switch para los menus
            switch (opc1){
                case 1:
                    if(!docum.isFile()){//inicioIf
                        System.out.println("\nNo se ha Creado ningun Tablero. \n\"Cree un tablero Nuevo\n");                      
                    }else{
                        
                   
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
                    //Casting de los objetos de tipo Tablero de nuestro vector.
                        for (int i = 0; i < tableros.size(); i++) {
                            
                           tab=(Tablero)tableros.elementAt(i);
                            System.out.println(contador +") "+ tab.toString());
                            contador++;
                        }
                     contador=1;
                        System.out.println("Desea Ingresar a algun Tablero");
                        System.out.println("Si/No");
                        opc2 = JA.next();
                        if (opc2.equals("Si")) {
                            System.out.println("Ingrese el Id de Tablero al que desea Ingresar");
                            opc3 = JA.nextInt();
                            
                            if (opc3 <= tableros.size()) {
                                opc3--;
                                do {
                                      System.out.println("\n1. Crear Lista de Tareas");
                                      System.out.println("2. Ver Listas De Taras");
                                      System.out.println("3. Cambiar nombre de Tablero");
                                      System.out.println("4. Borrar Tablero");
                                      System.out.println("5. Regresar al menu Principal");
                                      opc4 = JA.nextInt();
                                      
                                      switch (opc4){
                                          case 1:
                                              break;
                                          case 2:
                                              break;
                                          case 3:
                                              break;
                                              //*********************************************************************
                                          case 4:
                                              System.out.println("Esta seguro de que desea eliminar el Tablero \n S/N");
                                              opc5 = JA.next();
                                              if (opc5.equals("S")) {
                                                  //eliminar objeto en el vector especificado
                                                  tableros.remove(opc3);
                                                  System.out.println("Eliminando Tablero...");
                                                  System.out.println("Tablero Eliminado.");
                                                  //rescribir
                                                  try{                 
                                                    //Escribir en nuestro Archivo. el FileOutput es para escribir objetos en el archivos
                                                    FileOutputStream flujo = new FileOutputStream(docum);
                                                    ObjectOutputStream escObj = new ObjectOutputStream(flujo);

                                                    //escrib nuestro vector en nuestro archivo
                                                    escObj.writeObject(tableros);
                                                    
                                                  }catch(FileNotFoundException e){
                                                     e.printStackTrace();
                                                  }catch(IOException e){
                                                     e.printStackTrace();
                    }
                                                  
                                                  
                                                  //Lista actualizada
                                                  System.out.println("Lista de Tableros Actualizada");
                                                    for (int i = 0; i < tableros.size(); i++) {
                            
                                                  tab=(Tablero)tableros.elementAt(i);
                                                  System.out.println(contador +") "+ tab.toString());
                                                  contador++;
                                                }
                                                  contador=1;  
                                                  opc4 = 5;
                                              }else{
                                                  opc4 = 5;
                                              }
                                                  
                                              
                                              break;
                                              //************************************************************************
                                          case 5:
                                              opc4 = 5;
                                              break;
                                          default:
                                              System.out.println(error);
                                      } 
                                } while (opc4 !=5);
                            }else{
                                System.out.println(error);
                            }
                        }else{
                            System.out.println("Regresando...");
                        }

                   }//finElse
                    break;
                case 2:  
                    System.out.println("\n \n Ingrese el Nombre de su Tablero");
                    nomTab = JA.next();
                    try{
                        if(id != tableros.size()){
                            id = tableros.size()+1;
                        }
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
