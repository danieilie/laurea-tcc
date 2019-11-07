<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>
    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h3>Novo Perfil</h3>

            <form action="gerenciar_perfil.do" method="POST">
                <input type="hidden" name="idperfil" id="idperfil" value="${perfil.idperfil}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="perfil">Perfil</label>
                        <input type="text" class="form-control" id="perfil" name="perfil" required="" maxlength="45" value="${perfil.perfil}"/>
                    </div>    
                </div>    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_perfil.jsp" class="btn btn-warning">Voltar</a>    
                </div>    
            </form>  
        </div>
    </body>
</html>
