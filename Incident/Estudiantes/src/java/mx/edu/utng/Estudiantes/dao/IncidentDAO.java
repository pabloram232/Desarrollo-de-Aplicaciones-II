/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.Estudiantes.dao;

import java.util.List;
import mx.edu.utng.Estudiantes.model.Incident;
/**
 *
 * @author Irbing
 */
public interface IncidentDAO {
    void agregarIncident (Incident incident);
    void borrarIncident (int idIncident);
    void cambiarIncident (Incident incident);
    List<Incident> desplegarIncidents();
    Incident elegirIncident (int idIncident);
    
}
