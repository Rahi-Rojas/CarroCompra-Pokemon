<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Pokemon</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css">
</head>
<body>
<div class="login-container">
    <div class="left-section">
        <img src="<%=request.getContextPath()%>/images/poke.jpg" alt="Firma DaluER"> <!-- Reemplaza con la ruta de tu imagen -->
    </div>
    <div class="right-section">
        <div class="form-container">
            <h2>Bienvenido!</h2>
            <form method="post" action="login">
                <div class="form-group">
                    <label for="user">Usuario:</label>
                    <input type="text" id="user" name="user" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="btn-custom">Iniciar Sesión</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
