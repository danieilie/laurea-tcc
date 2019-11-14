<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Cadastrar Perfil</title>
    </head>
    <body>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="div_formulario">
            <form action="gerenciar_perfil.do" method="POST" class="form">
                <div class="form-group ">
                    <h2 class="titulo">Novo Perfil</h2>

                </div>
                <input type="hidden" name="idperfil" id="idperfil" value="${perfil.idperfil}"/>
                <div class="col-md-4 mb-3">

                    <label for="perfil">Perfil</label>
                    <input type="text" class="form-control" id="perfil" name="perfil" required="" maxlength="45" value="${perfil.perfil}"/>

                </div>    
                <div class="col-md-4 mb-3">
                    <button class="btn btn-primary">Gravar</button>
                    <a href="listar_perfil.jsp" class="btn btn-outline-dark">Voltar</a>    
                </div>    
            </form>  
        </div>
    </body>
</html>
