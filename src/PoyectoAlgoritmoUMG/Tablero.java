package PoyectoAlgoritmoUMG;
/**
 *
 * @author avila
 */
public class Tablero {
    /* La clase tablero fue creaada para almacenar los objetos de tipo tablero 
    se necesita el atributo nombre de tablero para almacenar los nombres y el de idTab
    para el identificor unico*/
    private String NomTab;
    private int idTab;
    
    //metodo Constructor
    public Tablero(String NomTab, int idTab) {
        this.NomTab = NomTab;
        this.idTab = idTab;
    }
    //metodo Consultor
    public String getNomTab() {
        return this.NomTab;
    }

    public int getIdTab() {
        return this.idTab;
    }
    //metodo modificador
    public void setNomTab(String NomTab) {
        this.NomTab = NomTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }
    
}
