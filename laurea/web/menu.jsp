<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controller.GerenciarLogin"%>
<%@page import="model.Usuario"%>

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
<link rel="stylesheet" type="text/css" href="estilo/menu.css"/>

