<%-- 
    Document   : estudiante
    Created on : 20/09/2016, 12:24:43 PM
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incident</title>
    </head>
    <body>
        <form action="IncidentController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>

                <div> 
                    <label for="idIncident"> Id Incident:</label>
                    <input type="text" name="idIncident" value="${incident.idIncident}"
                           readonly="readonly" placeholder="Id Incident" />
                </div>

                <div> 
                    <label for="idParent"> id Parent:</label>
                    <input type="text" name="idParent" value="${incident.idParent}"
                           placeholder="id Parent" />
                </div>

                <div> 
                    <label for="idSearch"> id Search:</label>
                    <input type="text" name="idSearch" value="${incident.idSearch}"
                           placeholder="id Search" />
                </div>

                <div> 
                    <label for="name"> name:</label>
                    <input type="text" name="name" value="${incident.name}"
                           placeholder="name" />
                </div>

               

                <div> 
                    <input type="submit" value="Guardar"/>
                </div>

            </fieldset>
        </form>
    </body>
</html>
