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
        int id= 1;//tabas
        int contador = 1; //para contador/id tablero
        int opc3 = 0; //para ingresar al tablero
        int opc4 = 0;//opc de opciones del tablero
        int pivote = 0 ; //para remover el tab a la hora de cambiar name.
        int idLisTa = 1;//Id lista Tarea
        int contadorLista = 1; //para contador/id de la lista de Tareas
        int opc7 = 0; //para ingresar a una lista de Tareas
        int pivoteLisTa = 0;//pivote para lista de tareas
        int opc8 = 0; //opciones de lista de tareas
        
        String opc5 = " ";//opcion de eliminar un tablero
        String error = "Error, Porfavor Digite una opcion Valida"; //para mostrar error
        String nomTab=""; //para guardar el nombre del tablero
        String opc2 = " "; //confirmacion de ingresar a un tablero
        String newNameTab="";//Cambiar nombre al Tablero
        String nameLisTar=""; //Para la lista de tareas
        String opc6 = ""; //confirmacion de ingresar a una Lista de Tareas
        String opc9 = " "; //opcion de eliminar una Lista de Tareas
        String newNameLisTa = ""; //para guardar el nuevo nombre de la lisTa de Tareas
        
        
        
        
        //Creamos nuestros archivos
        File docum = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\tabs.txt");
        File documListTa = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\Lista Tareas\\ListaTarea.txt");
        
        
        //nuestra referencia del objetos 
        Tablero tab;
        Lista_Tarea lisTa;
        
        //Vectores
        Vector tableros = new Vector(); 
        Vector listTarea = new Vector();
        
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
                        //leer archivo nuestro vector de Tableros
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
                        System.out.println("Bienvenido a su Lista de Tableros");
                        for (int i = 0; i < tableros.size(); i++) {                          
                         tab=(Tablero)tableros.elementAt(i);                           
                         System.out.println(contador +") "+ tab.toString());
                         contador++;
                        }
                         contador=1;
                         System.out.println("\nDesea Ingresar a algun Tablero");
                         System.out.println("Si/No");
                         opc2 = JA.next();
                        if (opc2.equals("Si")) {
                            System.out.println("Ingrese el Id de Tablero al que desea Ingresar");
                            opc3 = JA.nextInt();
                            
                            if (opc3 <= tableros.size()) {
                                pivote = opc3 -1;
                                do {
                                      System.out.println("\n1. Ver Listas De Taras");
                                      System.out.println("2. Crear Lista de Tareas");
                                      System.out.println("3. Cambiar nombre de Tablero");
                                      System.out.println("4. Borrar Tablero");
                                      System.out.println("5. Regresar al menu Principal");
                                      opc4 = JA.nextInt();
                                      
                                      switch (opc4){
      
                                          case 1:
                                              if (!documListTa.isFile()) { //inicio if
                                                  System.out.println("\nNo se ha Creado ninguna Lista de Tareas. \nCree una Nueva Lista de Tareas\n"); 
                             /*finIF*/        }else{ //inicio else leer lista tareas                                            
                                                try{
                                                  //leer archivo nuestro Vector de Lista Tareas
                                                  FileInputStream leerLisTa = new FileInputStream (documListTa);
                                                  ObjectInputStream leerobjLisTa = new ObjectInputStream(leerLisTa);
                                                  //Castiiiing para hacer el cambio de un tipo de dato a otro
                                                  listTarea=(Vector)leerobjLisTa.readObject();    

                                              }catch(FileNotFoundException e){
                                                  e.printStackTrace();

                                              }catch(IOException e){
                                                  e.printStackTrace();

                                              }catch(ClassNotFoundException e){
                                                  e.printStackTrace();                        
                                              }
                                                 //Casting de los objetos de tipo Tablero de nuestro vector.
                                                System.out.println("Bienvenido a sus Listas de Tareas");
                                                for (int i = 0; i < listTarea.size(); i++) {                          
                                                 lisTa=(Lista_Tarea)listTarea.elementAt(i);                           
                                                 System.out.println(contadorLista + ") "+ lisTa.mostList());
                                                 contadorLista++;
                                            }
                                                 contadorLista=1;
                                                 System.out.println("\nDesea Ingresar a alguna Lista De Tareas");
                                                 System.out.println("Si/No");
                                                 opc6 = JA.next();
                                                  if (opc6.equals("Si")) {
                                                       System.out.println("Ingrese el Id de la Lista a la que desea Ingresar");
                                                       opc7 = JA.nextInt();
                                                       if (opc7 <= tableros.size()) {
                                                           pivoteLisTa = opc3 -1;
                                                           do {
                                                               System.out.println("\n1. Ver Taras");
                                                               System.out.println("2. Crear Tareas");
                                                               System.out.println("3. Cambiar nombre de Lista de Tareas");
                                                               System.out.println("4. Borrar Lista de Tareas");
                                                               System.out.println("5. Regresar al menu Principal");
                                                               opc8 = JA.nextInt();
                                                               switch (opc8){
                                                                   case 1:
                                                                       break;
                                                                        
                                                                   case 2:
                                                                       
                                                                       break;
         //**************************************************************************************************************************************************************                                                                     
                                                                   case 3:// Cambiar name a la lista de Tareas                                                                      
                                                                        System.out.println("Ingrese el nuevo nombre de La Lista de Taras");
                                                                        newNameLisTa = JA.next();   
                                                                        //eliminar tab
                                                                        listTarea.remove(pivoteLisTa);
                                                                        //
                                                                        lisTa = new Lista_Tarea (newNameLisTa,pivoteLisTa);
                                                                           try{
                                                                          //Sobreescribiendo nuestro objeto para el cambio de nombre
                                                                        FileOutputStream cambioNameLisTa = new FileOutputStream (documListTa);
                                                                        ObjectOutputStream objCamNameLisTa = new ObjectOutputStream(cambioNameLisTa);
                                                                        listTarea.add(pivoteLisTa,lisTa);
                                                                        objCamNameLisTa.writeObject(listTarea);



                                                                        }catch(FileNotFoundException e){
                                                                         e.printStackTrace();

                                                                        }catch(IOException e){
                                                                         e.printStackTrace();
                                                                        }
                                                                         System.out.println("\nEl Nombre se ha Cambiado Exitosamente");
                                                                       
                                                                       break;
         //*************************************************************************************************************************************************************                                                               
                                                                   case 4://borrar tab
                                                                      
                                                                        System.out.println("Esta seguro de que desea eliminar una lista de Tareas \n S/N");
                                                                        opc9 = JA.next();
                                                                        if (opc9.equals("S")) {
                                                                            //eliminar objeto en el vector especificado
                                                                            listTarea.remove(opc7);
                                                                            System.out.println("Eliminando Lista de Tareas...");
                                                                            System.out.println("Lista de Tareas Eliminada.");
                                                                            //rescribir
                                                                            try{                 
                                                                              //Escribir en nuestro Archivo. el FileOutput es para escribir objetos en el archivos
                                                                              FileOutputStream flujo = new FileOutputStream(documListTa);
                                                                              ObjectOutputStream escObj = new ObjectOutputStream(flujo);

                                                                              //escrib nuestro objeto en nuestro vector
                                                                              escObj.writeObject(listTarea);

                                                                            }catch(FileNotFoundException e){
                                                                               e.printStackTrace();
                                                                            }catch(IOException e){
                                                                               e.printStackTrace();
                                                                            }


                                                                            //Lista actualizada
                                                                            System.out.println("Lista de Tareas Actualizada");
                                                                              for (int i = 0; i < listTarea.size(); i++) {

                                                                            lisTa=(Lista_Tarea)listTarea.elementAt(i);
                                                                            System.out.println(contadorLista +") "+ lisTa.mostList());
                                                                            contadorLista++;
                                                                          }
                                                                            contadorLista=1;  
                                                                            opc8 = 5;
                                                                        }else{
                                                                            opc8 = 5;
                                                                        }
                                                                       break;
                                                                       
                                                                   case 5:
                                                                       opc8 = 5;
                                                                       break;
                                                                   default:
                                                                       System.out.println(error);
                                                               }     
                                                           } while (opc8 !=5);
                                                      }else{ //inicio else pivote
                                                           
                                                       } //fin else pivote
                                                  }else{//inicio else equals
                                                      System.out.println("Regresando...");
                                                  }//fin else equals
                                              }//Fin else leer lista de tareas
                                              break;
                                              
                                          case 2:
                                              System.out.println("Ha seleccionado la opcion: " + opc4 + " Crear una lista de Tarea") ;      
                                              System.out.println("Ingrese el nombre de su Nueca Lista de Tareas");
                                              nameLisTar = JA.next();
                                              try{
                                                  if(idLisTa != listTarea.size()){
                                                     idLisTa = listTarea.size()+1;
                                                    }
                                                lisTa = new Lista_Tarea(nameLisTar,idLisTa);
                                                idLisTa++;
                                                listTarea.add(lisTa);
                                                //Escribiendo Nuestras Lista de Tareas
                                                FileOutputStream crearLisTa = new FileOutputStream (documListTa);
                                                ObjectOutputStream objLisTa = new ObjectOutputStream(crearLisTa);
                                                
                                                
                                                objLisTa.writeObject(listTarea);
                                                System.out.println("La Lista Tableros '" + nameLisTar + "' Se creo Exitosamente\n" );
                                                
                                                 

                                              }catch(FileNotFoundException e){
                                                e.printStackTrace();

                                              }catch(IOException e){
                                                e.printStackTrace();
                                              }
                                              System.out.println("La Lista de Tareas Se Ha Creado Exitosamente");
                                              
                                              break;
      
                                          case 3: //cambair nombre tab
                                              System.out.println("Ingrese el nuevo Nombre del Tablero");
                                              newNameTab = JA.next();   
                                              //eliminar tab
                                              tableros.remove(pivote);
                                              //
                                              tab = new Tablero (newNameTab,pivote);
                                                 try{
                                                //Sobreescribiendo nuestro objeto para el cambio de nombre
                                              FileOutputStream cambioName = new FileOutputStream (docum);
                                              ObjectOutputStream objCamName = new ObjectOutputStream(cambioName);
                                              tableros.add(pivote,tab);
                                              objCamName.writeObject(tableros);
                                              
                                                 

                                              }catch(FileNotFoundException e){
                                               e.printStackTrace();

                                              }catch(IOException e){
                                               e.printStackTrace();
                                              }
                                               System.out.println("\nEl Nombre se ha Cambiado Exitosamente");
                                              
                                              break;
      
                                          case 4://Borrar Tab
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
                                                    
                                                    //escrib nuestro objeto en nuestro vector
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
                                           
                                          case 5://Regresar
                                              opc4 = 5;
                                              break;
                                          default://error
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
