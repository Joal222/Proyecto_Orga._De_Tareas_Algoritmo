package PoyectoAlgoritmoUMG;

/**
 *
 * @author avila
 */
public class Lista_Tarea {
    /*En la clase Lista tareas se creo para almacenar todos los objetos de clase listaTarea
    necesitaremos un atributo para el nombre de la lista y uno para el identificador unico*/
    private String nomList;
    private int idList;
    //metodo constructor
    public Lista_Tarea(String nomList, int idList) {
        this.nomList = nomList;
        this.idList = idList;
    }
    //metodo consultor
    public String getNomList() {
        return this.nomList;
    }

    public int getIdList() {
        return this.idList;
    }
    //metodo modificador 
    public void setNomList(String nomList) {
        this.nomList = nomList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }
    
    
   
}
