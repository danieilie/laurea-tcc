<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Usuario"%>
<%@page import="controller.GerenciarLogin"%>


<link rel="stylesheet" type="text/css" href="estilo/banner.css" /> 

<div class="logo">
    <img src="assets/img/logo/logo_menu.png"> 

    <c:if test="${ulogado!=null}">${ulogado.nome}</c:if>

</div>
