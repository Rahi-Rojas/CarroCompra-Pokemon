<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1 = request.getSession(false);
    String username = (String) session1.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bienvenido <%=username%></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/home.css">
</head>
<body>
<div class="container">
    <%if (username != null) {%>
    <h1>Bienvenido a la tienda virtual, <%=username%>!</h1>
    <%}else {%>
    <h1>Por favor, inicia sesión para acceder a la tienda virtual</h1>
    <%}%>
    <p>Estás en la página de Home</p>

    <div class="actions">
        <a href="index.jsp" class="btn btn-primary">Ir a Inicio</a>
        <a href="logout" class="btn btn-danger">Cerrar Sesión</a>
    </div>
</div>
</body>
</html>

