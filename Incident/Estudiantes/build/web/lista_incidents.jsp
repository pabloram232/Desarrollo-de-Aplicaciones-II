<%-- 
    Document   : lista_estudiantes
    Created on : 20/09/2016, 12:29:24 PM
    Author     : Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de incidents</title>
    </head>
    <body>
        <table>
            <thead> 
            <tr>
                <th> Id Incident :</th>
                <th>Id Parent:</th>
                <th>Id Search</th>
                <th>Name:</th>
               
            </tr>
            </thead>
            <tbody>
                <c:forEach var="incident" items="${incidents}">
                    <tr>
                        <td>${incident.idIncident}</td>
                        <td>${incident.idParent}</td>
                        <td>${incident.idSearch}</td>
                        <td>${incident.name}</td>
                       
                        <td><a href="IncidentController?action=cambiar&idIncident=${incident.idIncident}">Cambiar</a></td>
                        <td><a href="IncidentController?action=borrar&idIncident=${incident.idIncident}">Borrar</a></td>
                    </tr>                    
                </c:forEach>
            </tbody>
            
        </table>
        <p>
            <a href="IncidentController?action=agregar">
                Agregar Incident
            </a>
        </p>
    </body>
</html>
