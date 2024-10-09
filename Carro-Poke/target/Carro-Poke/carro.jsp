<%@ page import="com.rojas.spring.app.carropoke.models.Carro" %>
<%@ page import="com.rojas.spring.app.carropoke.models.ItemPokemon" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carrito de Compras</title>
    <link rel="stylesheet" href="styles/carro.css">
</head>
<body>
<h1>Carro de Compras</h1>
<%
    if (carro != null && !carro.getItemsCarro().isEmpty()) {
%>
<table align="center" border="2">
    <thead>
    <tr>
        <th>Id</th>
        <th>Producto</th>
        <th>Cantidad</th>
        <th>Precio</th>
        <th>SubTotal</th>
    </tr>
    </thead>
    <tbody>
    <% for (ItemPokemon pokemon : carro.getItemsCarro()) { %>
    <tr>
        <td><%= pokemon.getPokemon().getId() %></td>
        <td><%= pokemon.getPokemon().getNombre() %></td>
        <td><%= pokemon.getCantidad() %></td>
        <td><%= pokemon.getPokemon().getPrecio() %></td>
        <td><%= pokemon.getTotalItemPrecio() %></td>
    </tr>
    <% } %>
    <tr>
        <td colspan="4" align="right">Total:</td>
        <td><%= carro.getTotal() %></td>
    </tr>
    </tbody>
</table>
<%
} else {
%>
<p>El carrito está vacío.</p>
<%
    }
%>
</body>
</html>