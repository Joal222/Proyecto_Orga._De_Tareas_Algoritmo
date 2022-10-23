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
        int idTarea = 1; //id Tareas
        int contadorTarea = 1;//para contador/id de las tareas
        int opc11 = 0; //para ingresar a una Tareas 
        int pivoteTarea =0;//pivote para de tareas
        int opc12 = 0; //opciones de Tarea
        int idLisAc = 1;//id lista Actividades
        int contadorLisAc = 1;//para contador/id de la lista de Actividades
        int opc15 = 0; //para ingresar a una lista de actividades
        int pivoteListaAtiv = 0;//pivote para lista de Actividades
        int opc16 = 0; //opciones lista de Actividades
        int idAct = 1; // id para actividades
        int contadorAct = 1; //contador de actividades
        
        
        String opc5 = " ";//opcion de eliminar un tablero
        String error = "Error, Porfavor Digite una opcion Valida"; //para mostrar error
        String nomTab=""; //para guardar el nombre del tablero
        String opc2 = " "; //confirmacion de ingresar a un tablero
        String newNameTab="";//Cambiar nombre al Tablero
        String nameLisTar=""; //Para la lista de tareas
        String opc6 = ""; //confirmacion de ingresar a una Lista de Tareas
        String opc9 = " "; //opcion de eliminar una Lista de Tareas
        String newNameLisTa = ""; //para guardar el nuevo nombre de la lisTa de Tareas
        String nameTarea = "";//para las tareas
        String descTarea="";//para descripcion de la tarea
        String opc10 = ""; //confirmacion de ingresar a una Lista de Tareas
        String opc13=""; //opcion para eliminar una tarea
        String newNameTar = "";//para guardar el nuevo nombre de la tarea
        String nameLisAc = "";//para la Lista de Actividades
        String opc14 =" "; //confirmacion de ingresar a una Lista de Actividades
        String opc17 ="";//eliminar una lista de Actividades
        String newNameLisAc="";//cambiar nombre de lista de actividades
        String nameActi = ""; //para actividades
        String opc18 =""; //para confirmacion de ingreso a una actividad
        String opc19 = ""; //para ingresar a 
        
        //Creamos nuestros archivos
        File docum = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\tabs.txt");
        File documListTa = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\Lista Tareas\\ListaTarea.txt");
        File documTarea = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\Lista Tareas\\Tareas\\tarea.txt");
        File documlisActi = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\Lista Tareas\\Tareas\\Lista Actividades\\listActiv.txt");
        File documActi = new File ("C:\\Users\\avila\\OneDrive\\Escritorio\\Pro. Algo\\MyProyAlg\\Tablero_Orga\\Lista Tareas\\Tareas\\Lista Actividades\\Actividades\\activ.txt");
        
        
        //nuestra referencia del objetos 
        Tablero tab;
        Lista_Tarea lisTa;
        Tareas tar;
        Lista_Act lisAc;
        Actividades act;
        
        //Vectores
        Vector tableros = new Vector(); 
        Vector listTarea = new Vector();
        Vector tareas = new Vector ();
        Vector listaAct = new Vector ();
        Vector actividad = new Vector();
        
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
                case 1: //ver Tabs
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
                        System.out.println("Bienvenido a su Listado de Tableros");
                        for (int i = 0; i < tableros.size(); i++) {                          
                         tab=(Tablero)tableros.elementAt(i);                           
                         System.out.println(contador +") "+ tab.toString());
                         contador++;
                        }
                         contador=1;
                         System.out.println("\nDesea Ingresar a algun Tablero");
                         System.out.println("si/no");
                         opc2 = JA.next();
                        if (opc2.equals("si")) {
                            System.out.println("Ingrese el Id de Tablero al que desea Ingresar");
                            opc3 = JA.nextInt();
                            
                            if (opc3 <= tableros.size()) {
                                pivote = opc3 -1;
                                do {
                                      System.out.println("\nIngrese una Opcion");  
                                      System.out.println("1. Ver Listas De Taras");
                                      System.out.println("2. Crear Lista de Tareas");
                                      System.out.println("3. Cambiar nombre de Tablero");
                                      System.out.println("4. Borrar Tablero");
                                      System.out.println("5. Regresar al menu Principal");
                                      opc4 = JA.nextInt();
                                      
                                      switch (opc4){
      
                                          case 1: //ver lisTa
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
                                                System.out.println("Bienvenido a su Listado de Listas de Tareas");
                                                for (int i = 0; i < listTarea.size(); i++) {                          
                                                 lisTa=(Lista_Tarea)listTarea.elementAt(i);                           
                                                 System.out.println(contadorLista + ") "+ lisTa.mostList());
                                                 contadorLista++;
                                            }
                                                 contadorLista=1;
                                                 System.out.println("\nDesea Ingresar a alguna Lista De Tareas");
                                                 System.out.println("si/no");
                                                 opc6 = JA.next();
                                                  if (opc6.equals("si")) {
                                                       System.out.println("Ingrese el Id de la Lista a la que desea Ingresar");
                                                       opc7 = JA.nextInt();
                                                       if (opc7 <= listTarea.size()) {
                                                           pivoteLisTa = opc7 -1;
                                                           do {
                                                               System.out.println("\nIngrese una opcion");
                                                               System.out.println("1. Ver Taras");
                                                               System.out.println("2. Crear Tareas");
                                                               System.out.println("3. Cambiar nombre de Lista de Tareas");
                                                               System.out.println("4. Borrar Lista de Tareas");
                                                               System.out.println("5. Regresar al menu Principal");
                                                               opc8 = JA.nextInt();
                                                               switch (opc8){
                                                                   
                                                                   case 1://ver tareas
                                                                        if (!documTarea.isFile()) { //inicio if
                                                                            System.out.println("\nNo se ha Creado ninguna Tareas. \nCree una Nueva Tareas\n"); 
                                                       /*finIF*/        }else{ //inicio else leer tareas                                            
                                                                          try{
                                                                            //leer archivo nuestro Vector de Lista Tareas
                                                                            FileInputStream leerTarea = new FileInputStream (documTarea);
                                                                            ObjectInputStream leerobjTar = new ObjectInputStream(leerTarea);
                                                                            //Castiiiing para hacer el cambio de un tipo de dato a otro
                                                                            tareas=(Vector)leerobjTar.readObject();    

                                                                        }catch(FileNotFoundException e){
                                                                            e.printStackTrace();

                                                                        }catch(IOException e){
                                                                            e.printStackTrace();

                                                                        }catch(ClassNotFoundException e){
                                                                            e.printStackTrace();                        
                                                                        }
                                                                         //Casting de los objetos de tipo Tablero de nuestro vector.
                                                                            System.out.println("Bienvenido a su Listado de Tareas");
                                                                            for (int i = 0; i < tareas.size(); i++) {                          
                                                                             tar=(Tareas)tareas.elementAt(i);                           
                                                                             System.out.println(contadorTarea + ") "+ tar.mostTarea());
                                                                             contadorTarea++;
                                                                             }
                                                                                contadorTarea=1;
                                                                                System.out.println("\nDesea Ingresar a alguna Tareas");
                                                                                System.out.println("si/no");
                                                                                opc10 = JA.next();
                                                                                if (opc10.equals("si")) {
                                                                                    System.out.println("Ingrese el Id de la Tarea a la que desea Ingresar");
                                                                                    opc11 = JA.nextInt();    
                                                                                    if (opc11 <= tareas.size()) {
                                                                                        pivoteTarea = opc11 -1;
                                                                                        
                                                                                        do {
                                                                                            System.out.println("\nIngrese una Opcion");
                                                                                            System.out.println("1. Ver lista de Actividades");
                                                                                            System.out.println("2. Crear Lista de Actividades");
                                                                                            System.out.println("3. Cambiar nombre de la Tareas");
                                                                                            System.out.println("4. Borrar Tarea");
                                                                                            System.out.println("5. Regresar al menu Principal");
                                                                                            opc12 = JA.nextInt();
                                                                                            switch (opc12){
                                                                                                
                                                                                                case 1://ver listas de actividades
                                                                                                    if (!documlisActi.isFile()) {
                                                                                                        System.out.println("\nNo se ha Creado ninguna Lista de Actividades. \nCree una Nueva Lista de Actividades\n");  
                                                                                                    }else{ //inicio else ver Lista Actividades
                                                                                                      try{
                                                                                                        //leer archivo nuestro Vector de Lista Tareas
                                                                                                        FileInputStream leerlistaAct = new FileInputStream (documlisActi);
                                                                                                        ObjectInputStream leerobjlisAc = new ObjectInputStream(leerlistaAct);
                                                                                                        //Castiiiing para hacer el cambio de un tipo de dato a otro
                                                                                                        tareas=(Vector)leerobjlisAc.readObject();    

                                                                                                    }catch(FileNotFoundException e){
                                                                                                        e.printStackTrace();

                                                                                                    }catch(IOException e){
                                                                                                        e.printStackTrace();

                                                                                                    }catch(ClassNotFoundException e){
                                                                                                        e.printStackTrace();                        
                                                                                                    }
                                                                                                     //Casting de los objetos de tipo Tablero de nuestro vector.
                                                                                                        System.out.println("Bienvenido a su Listado de Listas de Actividades");
                                                                                                        for (int i = 0; i < listaAct.size(); i++) {                          
                                                                                                         lisAc=(Lista_Act)listaAct.elementAt(i);                           
                                                                                                         System.out.println(contadorLisAc + ") "+ lisAc.mostListAc());
                                                                                                         contadorLisAc++;
                                                                                                         }
                                                                                                            contadorLisAc=1;
                                                                                                            System.out.println("\nDesea Ingresar a una Lista de Actividades");
                                                                                                            System.out.println("si/no");
                                                                                                            opc14 = JA.next();  
                                                                                                            if (opc14.equals("si")) {
                                                                                                                 System.out.println("Ingrese el Id de la Lista de Actividades a la que desea Ingresar");
                                                                                                                 opc15 = JA.nextInt();
                                                                                                                 if (opc15 <= listaAct.size()) {
                                                                                                                     pivoteListaAtiv = opc15 -1;
                                                                                                                     
                                                                                                                     do {
                                                                                                                         System.out.println("\n Ingrese una Opcion");
                                                                                                                         System.out.println("1. Ver Actividades");
                                                                                                                         System.out.println("2. Crear Actividad");
                                                                                                                         System.out.println("3. Cambiar nombre de la Lista de Actividades");
                                                                                                                         System.out.println("4. Borrar Lista de Actividades");
                                                                                                                         System.out.println("5. Regresar al menu Principal");
                                                                                                                         opc16 = JA.nextInt();
                                                                                                                         switch (opc16){
                                                            //**************************************************************************************************************************************************************                                                                 
                                                                                                                             case 1://ver Actividades
                                                                                                                                 if (!documActi.isFile()) {
                                                                                                                                     System.out.println("\nNo se ha Creado ninguna Actividad. \nCree una Nueva Actividad\n"); 
                                                                                                                                 }else{
                                                                                                                                      try{
                                                                                                                                        //leer archivo nuestro Vector de Lista Tareas
                                                                                                                                        FileInputStream leeractiv = new FileInputStream (documActi);
                                                                                                                                        ObjectInputStream leerobjActi = new ObjectInputStream(leeractiv);
                                                                                                                                        //Castiiiing para hacer el cambio de un tipo de dato a otro
                                                                                                                                        actividad=(Vector)leerobjActi.readObject();    

                                                                                                                                      }catch(FileNotFoundException e){
                                                                                                                                          e.printStackTrace();

                                                                                                                                      }catch(IOException e){
                                                                                                                                          e.printStackTrace();

                                                                                                                                      }catch(ClassNotFoundException e){
                                                                                                                                          e.printStackTrace();                        
                                                                                                                                    }
                                                                                                                                      //Casting de los objetos de tipo Tablero de nuestro vector.
                                                                                                                                        System.out.println("Bienvenido a su Listado de Actividades");
                                                                                                                                        for (int i = 0; i < actividad.size(); i++) {                          
                                                                                                                                         act=(Actividades)actividad.elementAt(i);                           
                                                                                                                                         System.out.println(contadorAct + ") "+ act.mostAct());
                                                                                                                                         contadorAct++;
                                                                                                                                         }
                                                                                                                                            contadorAct=1;
                                                                                                                                            System.out.println("Desea regresar\nS/N");
                                                                                                                                            opc19 = JA.next();
                                                                                                                                            if (opc19.equals("S")) {
                                                                                                                                         opc16 = 5;
                                                                                                                                     }else{
                                                                                                                                                
                                                                                                                                            }
                                                                                                                                 }
                                                                                                                                 break;
                                                            //**************************************************************************************************************************************************************                                                                     
                                                                                                                             case 2://Crear Actividad
                                                                                                                                 System.out.println("Ha seleccionado la opcion: " + opc16 + " Crear una Actividad") ;      
                                                                                                                                 System.out.println("Ingrese el nombre de su nueva Actividad");
                                                                                                                                 nameActi = JA.next();

                                                                                                                                   try{
                                                                                                                                       if(idAct != actividad.size()){
                                                                                                                                          idAct = actividad.size()+1;
                                                                                                                                         }
                                                                                                                                     act = new Actividades (nameActi,idAct);
                                                                                                                                     idAct++;
                                                                                                                                     actividad.add(act);
                                                                                                                                     //Escribiendo Nuestras Lista de Tareas
                                                                                                                                     FileOutputStream crearActividad = new FileOutputStream (documActi);
                                                                                                                                     ObjectOutputStream objActiv = new ObjectOutputStream(crearActividad);


                                                                                                                                     objActiv.writeObject(actividad);
                                                                                                                                     System.out.println("La Actividad '" + nameActi + "' Se creo Exitosamente\n" );



                                                                                                                                   }catch(FileNotFoundException e){
                                                                                                                                     e.printStackTrace();

                                                                                                                                   }catch(IOException e){
                                                                                                                                     e.printStackTrace();
                                                                                                                                   }
                                                                                                                                    
                                                                                                                                 break;
                                                                                                                                  
                                                                                                                             case 3://cambiar nombre
                                                                                                                                  System.out.println("Ingrese el nuevo nombre de su Lista de Actividad");
                                                                                                                                    newNameLisAc = JA.next();   
                                                                                                                                    //eliminar tab
                                                                                                                                    listaAct.remove(pivoteListaAtiv);
                                                                                                                                    //
                                                                                                                                    lisAc = new Lista_Act (newNameLisAc,pivoteListaAtiv);
                                                                                                                                       try{
                                                                                                                                      //Sobreescribiendo nuestro objeto para el cambio de nombre
                                                                                                                                    FileOutputStream cambioNameLisAc = new FileOutputStream (documlisActi);
                                                                                                                                    ObjectOutputStream objCamNameLisAc = new ObjectOutputStream(cambioNameLisAc);
                                                                                                                                    listaAct.add(pivoteListaAtiv,lisAc);
                                                                                                                                    objCamNameLisAc.writeObject(listaAct);



                                                                                                                                    }catch(FileNotFoundException e){
                                                                                                                                     e.printStackTrace();

                                                                                                                                    }catch(IOException e){
                                                                                                                                     e.printStackTrace();
                                                                                                                                    }
                                                                                                                                     System.out.println("\nEl Nombre se ha Cambiado Exitosamente");
                                                                                                                                    
                                                                                                                                 break;
                                                                                                                                 
                                                                                                                             case 4://borrar Lista de Actividades
                                                                                                                                  System.out.println("Esta seguro de que desea eliminar su Lista de Actividad \n S/N");
                                                                                                                                    opc17 = JA.next();
                                                                                                                                    if (opc17.equals("S")) {
                                                                                                                                       //eliminar objeto en el vector especificado
                                                                                                                                       listaAct.remove(pivoteListaAtiv);
                                                                                                                                       System.out.println("Eliminando Lista de Actividades...");
                                                                                                                                       System.out.println("Lista de Actividades Eliminada.");
                                                                                                                                       //rescribir
                                                                                                                                       try{                 
                                                                                                                                         //Escribir en nuestro Archivo. el FileOutput es para escribir objetos en el archivos
                                                                                                                                         FileOutputStream flujolisAc = new FileOutputStream(documlisActi);
                                                                                                                                         ObjectOutputStream escObjLisAc = new ObjectOutputStream(flujolisAc);

                                                                                                                                         //escrib nuestro objeto en nuestro vector
                                                                                                                                         escObjLisAc.writeObject(listaAct);

                                                                                                                                       }catch(FileNotFoundException e){
                                                                                                                                          e.printStackTrace();
                                                                                                                                       }catch(IOException e){
                                                                                                                                          e.printStackTrace();
                                                                                                                                       }


                                                                                                                                       //Lista actualizada
                                                                                                                                       System.out.println("Lista de Actividades Actualizada");
                                                                                                                                         for (int i = 0; i < listaAct.size(); i++) {

                                                                                                                                       lisAc=(Lista_Act)listaAct.elementAt(i);
                                                                                                                                       System.out.println(contadorLisAc +") "+ lisAc.mostListAc());
                                                                                                                                       contadorLisAc++;
                                                                                                                                     }
                                                                                                                                       contadorLisAc=1;  
                                                                                                                                       opc16 = 5;
                                                                                                                                    }else{
                                                                                                                                       opc16 = 5;
                                                                                                                                    }
                                                                                                                                 break;
                                                                                                                                 
                                                                                                                             case 5://regresar al menu
                                                                                                                                 opc16 = 5;
                                                                                                                                 break;
                                                                                                                             default:
                                                                                                                                 System.out.println(error);
                                                                                                                         }
                                                                                                                     } while (opc16 !=5);
                                                                                                                }else{ //else pivote
                                                                                                                  System.out.println(error);   
                                                                                                                 } //fin else pivote                                                                                                                                                                                                                       
                                                                                                        }else{ //else equals
                                                                                                              System.out.println("Regresando...");  
                                                                                                            }//fin else equals
                                                                                                    } //Fin else lista Actividades
                                                                                                    
                                                                                                    break;
                                                                                                    
                                                                                                case 2: //Crear Lista de Actiividades
                                                                                                    System.out.println("Ha seleccionado la opcion: " + opc12 + " Crear una Lista de Actividades") ;      
                                                                                                    System.out.println("Ingrese el nombre de su nueva Lista de Actividades");
                                                                                                    nameLisAc = JA.next();
                                                                                                   
                                                                                                    try{
                                                                                                        if(idLisAc != listaAct.size()){
                                                                                                           idLisAc = listaAct.size()+1;
                                                                                                          }
                                                                                                      lisAc = new Lista_Act (nameLisAc,idLisAc);
                                                                                                      idLisAc++;
                                                                                                      listaAct.add(lisAc);
                                                                                                      //Escribiendo Nuestras Lista de Tareas
                                                                                                      FileOutputStream crearListaAct = new FileOutputStream (documlisActi);
                                                                                                      ObjectOutputStream objlistAc = new ObjectOutputStream(crearListaAct);


                                                                                                      objlistAc.writeObject(listaAct);
                                                                                                      System.out.println("La Lista de Actividaes '" + nameLisAc + "' Se creo Exitosamente\n" );



                                                                                                    }catch(FileNotFoundException e){
                                                                                                      e.printStackTrace();

                                                                                                    }catch(IOException e){
                                                                                                      e.printStackTrace();
                                                                                                    }
                                                                                                   
                                                                       
                                                                                                    break;
                                                                                                    
                                                                                                case 3://Cambiar nombre de la tarea
                                                                                                    System.out.println("Ingrese el nuevo nombre de la Tarea");
                                                                                                    newNameTar = JA.next();   
                                                                                                    //eliminar tab
                                                                                                    tareas.remove(pivoteTarea);
                                                                                                    //
                                                                                                    tar = new Tareas (newNameTar,descTarea,pivoteTarea);
                                                                                                       try{
                                                                                                      //Sobreescribiendo nuestro objeto para el cambio de nombre
                                                                                                    FileOutputStream cambioNameTare = new FileOutputStream (documTarea);
                                                                                                    ObjectOutputStream objCamNameTarea = new ObjectOutputStream(cambioNameTare);
                                                                                                    tareas.add(pivoteTarea,tar);
                                                                                                    objCamNameTarea.writeObject(tareas);



                                                                                                    }catch(FileNotFoundException e){
                                                                                                     e.printStackTrace();

                                                                                                    }catch(IOException e){
                                                                                                     e.printStackTrace();
                                                                                                    }
                                                                                                     System.out.println("\nEl Nombre se ha Cambiado Exitosamente");
                                                                                                    break;
                                                                                                                            
                                                                                                case 4://Borrar Tarea
                                                                                                     System.out.println("Esta seguro de que desea eliminar una Tarea \n S/N");
                                                                                                     opc13 = JA.next();
                                                                                                     if (opc13.equals("S")) {
                                                                                                        //eliminar objeto en el vector especificado
                                                                                                        tareas.remove(pivoteTarea);
                                                                                                        System.out.println("Eliminando Tarea...");
                                                                                                        System.out.println("Tarea Eliminada.");
                                                                                                        //rescribir
                                                                                                        try{                 
                                                                                                          //Escribir en nuestro Archivo. el FileOutput es para escribir objetos en el archivos
                                                                                                          FileOutputStream flujoTar = new FileOutputStream(documTarea);
                                                                                                          ObjectOutputStream escObjTar = new ObjectOutputStream(flujoTar);

                                                                                                          //escrib nuestro objeto en nuestro vector
                                                                                                          escObjTar.writeObject(tareas);

                                                                                                        }catch(FileNotFoundException e){
                                                                                                           e.printStackTrace();
                                                                                                        }catch(IOException e){
                                                                                                           e.printStackTrace();
                                                                                                        }


                                                                                                        //Lista actualizada
                                                                                                        System.out.println("Tareas Actualizadas");
                                                                                                          for (int i = 0; i < tareas.size(); i++) {

                                                                                                        tar=(Tareas)tareas.elementAt(i);
                                                                                                        System.out.println(contadorTarea +") "+ tar.mostTarea());
                                                                                                        contadorTarea++;
                                                                                                      }
                                                                                                        contadorTarea=1;  
                                                                                                        opc12 = 5;
                                                                                                     }else{
                                                                                                        opc12 = 5;
                                                                                                     }
                                                                       
                                                                                                    break;
                                                                                                                                            
                                                                                                case 5:
                                                                                                    opc12 = 5;
                                                                                                    break;                                                                                                   
                                                                                                default:
                                                                                                    System.out.println(error);
                                                                                            }
                                                                                        } while (opc12 !=5);
                                                                                    }else{ //else pivote
                                                                                      System.out.println(error);  
                                                                                    }//fin else pivote
                                                                            }else{//else equals
                                                                                  System.out.println("Regresando...");   
                                                                                }//fin else equals
                                                                            
                                                                        }//Fin else leer tareas
                                                                       break;
                                                                        
                                                                   case 2://crear Tarea
                                                                        System.out.println("Ha seleccionado la opcion: " + opc4 + " Crear una Tarea") ;      
                                                                        System.out.println("Ingrese el nombre de su Nueva Tarea");
                                                                        nameTarea = JA.next();
                                                                        System.out.println("Agregue una Descripcion a su Tarea");
                                                                        descTarea = JA.next();
                                                                        try{
                                                                            if(idTarea != tareas.size()){
                                                                               idTarea = tareas.size()+1;
                                                                              }
                                                                          tar = new Tareas(nameTarea,descTarea,idTarea);
                                                                          idTarea++;
                                                                          tareas.add(tar);
                                                                          //Escribiendo Nuestras Lista de Tareas
                                                                          FileOutputStream crearTarea = new FileOutputStream (documTarea);
                                                                          ObjectOutputStream objTarea = new ObjectOutputStream(crearTarea);


                                                                          objTarea.writeObject(tareas);
                                                                          System.out.println("La Tarea '" + nameTarea + "' Se creo Exitosamente\n" );



                                                                        }catch(FileNotFoundException e){
                                                                          e.printStackTrace();

                                                                        }catch(IOException e){
                                                                          e.printStackTrace();
                                                                        }
                                                                        
                                                                       
                                                                       break;
                                                                              
                                                                   case 3:// Cambiar name a la lista de Tareas                                                                      
                                                                        System.out.println("Ingrese el nuevo nombre de La Lista de Tareas");
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
                                                                        
                                                                   case 4://borrar Lista de Tareas
                                                                      
                                                                        System.out.println("Esta seguro de que desea eliminar una lista de Tareas \n S/N");
                                                                        opc9 = JA.next();
                                                                        if (opc9.equals("S")) {
                                                                            //eliminar objeto en el vector especificado
                                                                            listTarea.remove(pivoteLisTa);
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
                                                           System.out.println(error);
                                                       } //fin else pivote
                                                  }else{//inicio else equals
                                                      System.out.println("Regresando...");
                                                  }//fin else equals
                                              }//Fin else leer lista de tareas
                                              break;
                                              
                                          case 2:
                                              System.out.println("Ha seleccionado la opcion: " + opc4 + " Crear una lista de Tarea") ;      
                                              System.out.println("Ingrese el nombre de su Nueva Lista de Tareas");
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
                                                System.out.println("La Lista de Tareas '" + nameLisTar + "' Se creo Exitosamente\n" );
                                                
                                                 

                                              }catch(FileNotFoundException e){
                                                e.printStackTrace();

                                              }catch(IOException e){
                                                e.printStackTrace();
                                              }
                                              
                                              
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
                                                  tableros.remove(pivote);
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
                    System.out.println("Espero haya disfrutado Esta linda Experiencia :)");
                    opc1 = 2;
                    System.exit(0); 
                    break;
                default:
                    System.out.println(error);
                    
            }
            
        } while (opc1 != 3);
        
    }//main
}
