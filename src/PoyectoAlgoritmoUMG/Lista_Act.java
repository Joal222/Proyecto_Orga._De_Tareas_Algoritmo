package PoyectoAlgoritmoUMG;

/**
 *
 * @author avila
 */
public class Lista_Act {
    /*En la clase Lista Actividades se guardaran los objetos creados de clase lista Activ, 
    se nesetan los atributos nombre de lista, fecha de la lista y id para le identificador unico*/
    private String nomlisAct;
    private String fechaLisAct;
    private int idLisAct;
    
    //metodo constructor
    public Lista_Act(String nomlisAct, String fechaLisAct, int idLisAct) {
        this.nomlisAct = nomlisAct;
        this.fechaLisAct = fechaLisAct;
        this.idLisAct = idLisAct;
    }
    //metodo Consultor
    public String getNomlisAct() {
        return this.nomlisAct;
    }

    public String getFechaLisAct() {
        return this.fechaLisAct;
    }

    public int getIdLisAct() {
        return this.idLisAct;
    }
    //metodo Modificador 
    public void setNomlisAct(String nomlisAct) {
        this.nomlisAct = nomlisAct;
    }

    public void setFechaLisAct(String fechaLisAct) {
        this.fechaLisAct = fechaLisAct;
    }

    public void setIdLisAct(int idLisAct) {
        this.idLisAct = idLisAct;
    }
   public String mostListAc (){
       return "La lista de actividad es: " + this.nomlisAct;
   }
   
    
}
