package mx.edu.utng.Estudiantes.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.Estudiantes.dao.IncidentDAOImp;
import mx.edu.utng.Estudiantes.model.Incident;
import mx.edu.utng.Estudiantes.dao.IncidentDAO;

public class IncidentController extends HttpServlet {
    private static final String LISTA_INCIDENTS = "/lista_incidents.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/incident.jsp";
    private IncidentDAO dao ;
    
    public IncidentController(){
        dao = new IncidentDAOImp();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")){
            forward = LISTA_INCIDENTS; //va a cambiar, ya uqe borro los estudiantes con id especifico
            int idIncident = Integer.parseInt(
            request.getParameter("idIncident"));
            dao.borrarIncident(idIncident);
            request.setAttribute("incidents", dao.desplegarIncidents()); //Listar nuevamente sin el valor borrado
        }else if (action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_O_CAMBIAR;
             int idIncident = Integer.parseInt(
            request.getParameter("idIncident"));
             Incident incident = dao.elegirIncident(idIncident);
             request.setAttribute("incident", incident);
        }else if (action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_O_CAMBIAR;
        }else{
            forward = LISTA_INCIDENTS;
            request.setAttribute("incidents", dao.desplegarIncidents());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward); //Se va adeterminada vista o a otra
        view.forward(request, response); 
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Incident incident = new Incident();
        incident.setIdParent(Integer.parseInt(request.getParameter("idParent")));
        incident.setIdSearch(request.getParameter("idSearch"));
        incident.setName(request.getParameter("name"));
      
        String idIncident = request.getParameter("idIncident");
        
        if(idIncident==null || idIncident.isEmpty()){
                dao.agregarIncident(incident);
            }else{
            incident.setIdIncident(Integer.parseInt(idIncident));
            dao.cambiarIncident(incident);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_INCIDENTS);
        request.setAttribute("incidents", dao.desplegarIncidents());
        view.forward(request, response);
    }
}