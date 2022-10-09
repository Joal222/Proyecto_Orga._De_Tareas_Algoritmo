package PoyectoAlgoritmoUMG;

/**
 *
 * @author avila
 */
public class Tareas {
    /*En la clase tareas se almacenaran todos los objetos de clase tareas
    necesitamos un atributo para el nombre de la tarea, uno para la descripción 
    y un atributo para el identificador unico*/
    private String nomTar;
    private String descriTar;
    private int idTar;
    
    //metodo constructor
    public Tareas(String nomTar, String descriTar, int idTar) {
        this.nomTar = nomTar;
        this.descriTar = descriTar;
        this.idTar = idTar;
    }
    //metodo Consultor
    public String getNomTar() {
        return nomTar;
    }

    public String getDescriTar() {
        return descriTar;
    }

    public int getIdTar() {
        return idTar;
    }
    //metodo modificador
    public void setNomTar(String nomTar) {
        this.nomTar = nomTar;
    }

    public void setDescriTar(String descriTar) {
        this.descriTar = descriTar;
    }

    public void setIdTar(int idTar) {
        this.idTar = idTar;
    }
    
    
    
}
