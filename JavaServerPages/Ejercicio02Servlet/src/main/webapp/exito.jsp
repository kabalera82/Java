<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="logica.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Lista Usuarios Registrados</h1>

<%
    List<Usuario> listaUsuarios = (List<Usuario>) session.getAttribute("listaUsuarios");
    int contador = 1;
%>

    <%
        for (Usuario user : listaUsuarios) {
    %>
        <hr>
        <p><b>Usuario Nº <%= contador %></b></p>
        <hr>
        <p>DNI: <%= user.getDni() %></p>
        <p>Nombre: <%= user.getNombre() %></p>
        <p>Apellido: <%= user.getApellido() %></p>
        <p>Teléfono: <%= user.getTelefono() %></p>
        <hr>
    <%
            contador++;
        }
    %>



</body>
</html>
