package PoyectoAlgoritmoUMG;

import java.io.Serializable;

/**
 *
 * @author avila
 */
public class Actividades implements Serializable {
    /* la clase actividad se creo para almacenar los objetos de tipo Actividades
    necesita los atributos nombre de la activida, el estado de la actividad y una 
    para el identificador unico*/
    private String nomAct;
   // private String estadoAct;
    private int idAct;
    
    
    //metodo Constructor 
    public Actividades(String nomAct,  int idAct) {
        this.nomAct = nomAct;
       // this.estadoAct = estadoAct;
        this.idAct = idAct;
    }
    //metodo Consultor
    public String getNomAct() {
        return this.nomAct;
    }

   /* public String getEstadoAct() {
        return this.estadoAct;
    }*/

    public int getIdAct() {
        return this.idAct;
    }
    //metodo modificador
    public void setNomAct(String nomAct) {
        this.nomAct = nomAct;
    }

 /*   public void setEstadoAct(String estadoAct) {
        this.estadoAct = estadoAct;
    }*/

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }
    public String mostAct (){
         return "La Actividad es:" + this.nomAct;
    }
   
    
    
}
