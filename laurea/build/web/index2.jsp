<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="controller.GerenciarLogin"%>
<%@page import="model.Usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Láurea </title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="assets/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="assets/css/reset.css">
        <!-- Bootstrap versão 4.1 -->
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_geral.css">
        <script type="text/javascript">document.documentElement.classList.add("js");</script>
        <!-- Tipografia -->
        <link href="https://fonts.googleapis.com/css?family=Bubblegum+Sans|Pontano+Sans|Port+Lligat+Sans&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="./assets/img/logo/logo_menu.png"/>
        <link rel="stylesheet" type="text/css" href="estilo/menu.css"/>
    </head>
    <body>
        <%--<%@include file="./banner.jsp" %>--%>
        <div class="container">
            <header class="" >
                <div class="">
                    <div class="logo">Láurea<img src="./assets/img/logo/logo_menu.png"></div> 
                    <nav>
                        <ul>
                            <li>
                                <div class="">
                                    <div class="pull-right">Bem vindo, 
                                        <c:if test="${ulogado!=null}">${ulogado.nome}</c:if>
                                        <a href="gerenciar_login.do">Sair<img src="https://image.flaticon.com/icons/svg/126/126467.svg" width="20"></a>
                                    </div>
                                </div>
                            </li>       
                        </ul>
                    </nav>
                </div>
            </header>
        <%--<%@include file="./menu.jsp" %>--%>             
            <%
                Usuario ulogado = GerenciarLogin.verificarAcesso(request, response);
                request.setAttribute("ulogado", ulogado);
            %>
            <div class="menu">
                <ul>
                <c:if test="${ulogado != null && ulogado.perfil != null}">
                    <c:forEach var="menu" items="${ulogado.perfil.menus}">
                        <c:if test="${menu.exibir == 1}">
                            <li><a href="${menu.link}">${menu.menu}</a></li>                   
                        </c:if>    
                    </c:forEach>
                </c:if>
                </ul>
            </div>  
            <h1>Home</h1>
        </div>
    </body>
</html>
