/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.Estudiantes.model;

/**
 *
 * @author Irbing
 */
public class Incident {
    private int idIncident;
    private int idParent;
    private String idSearch;
    private String name;
     ;
    

    public Incident() {
        this(0,0, "","" );
    }
    
    public Incident(int idIncident, int idParent, String idSearch, String name) {
        this.idIncident = idIncident;
        this.idParent = idParent;
        this.idSearch = idSearch;
        this.name = name;
       
        
    }   

    public int getIdIncident() {
        return idIncident;
    }

    public void setIdIncident(int idIncident) {
        this.idIncident = idIncident;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public String getIdSearch() {
        return idSearch;
    }

    public void setIdSearch(String idSearch) {
        this.idSearch = idSearch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Incident{" + "idIncident" + idIncident + ", idParent=" + idParent + ", idSearch=" + idSearch + ", name=" + name +  '}';
    }
    
}
