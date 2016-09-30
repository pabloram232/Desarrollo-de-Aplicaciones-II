/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.Estudiantes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.Estudiantes.model.Incident;
import mx.edu.utng.Estudiantes.util.UtilDB;
/**
 *
 * @author Pablo
 */
import mx.edu.utng.Estudiantes.util.UtilDB;
public class IncidentDAOImp implements IncidentDAO{

    private Connection connection;
    
    public IncidentDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarIncident(Incident incident) {
        try{
            String query = "INSERT INTO incidents(id_parent, id_search, name) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, incident.getIdParent());
            ps.setString(2, incident.getIdSearch());
            ps.setString(3, incident.getName());
            
              
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarIncident(int idIncident) {
        try{
            String query = "DELETE FROM incidents WHERE id_incident = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, idIncident);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarIncident(Incident incident) {
        try{
            String query = "UPDATE incidents SET id_parent = ?, id_search = ?, name = ?"
                    + " WHERE id_incident = ?";
            PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, incident.getIdParent());
            ps.setString(2, incident.getIdSearch());
            ps.setString(3, incident.getName());
            
            ps.setInt(4, incident.getIdIncident());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Incident> desplegarIncidents() {
        List<Incident> incidents = new ArrayList<Incident>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM incidents");
            while (resultSet.next()) {
                Incident inciden= new Incident(
                resultSet.getInt("id_incident"), 
                resultSet.getInt("id_parent"),
                resultSet.getString("id_search"),
                resultSet.getString("name"));
                
                incidents.add(inciden); //a la lista se le agregan los estudiantes que se le acaban de agregar datos
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return incidents;
    }

    @Override
    public Incident elegirIncident(int idIncident) {
        Incident incident = new Incident();
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM incidents"
                + " WHERE id_incident = ?");
        statement.setInt(1, idIncident);
        
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                incident.setIdIncident(resultSet.getInt("id_incident")); 
                incident.setIdParent(resultSet.getInt("id_parent"));
              incident.setIdSearch(resultSet.getString("id_search"));
               incident.setName(resultSet.getString("name"));
              
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return incident;
    }
}
