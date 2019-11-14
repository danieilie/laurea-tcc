<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Cadastrar Menu</title>
    </head>
    <body class="body">
        <%@include file="menu.jsp" %>

        <div class="div_formulario">

            <form action="gerenciar_menu.do" method="POST" class="form">
                <div class="form-group ">
                    <h2 class="titulo">Novo Menu</h2>
                    <div class="campo_obrigatorio">* campos de preenchimento obrigatório</div>
                </div>
                <input type="hidden" name="idmenu" id="idmenu" value="${menu.idmenu}"/>
                <div class="col-md-4 mb-3 ">

                    <label for="menu">Menu*</label>
                    <input type="text" class="form-control" id="menu" name="menu" required="" maxlength="45" value="${menu.menu}"/>

                </div>    
                <div class="col-md-4 mb-3 ">

                    <label for="link">Link*</label>
                    <input type="text" class="form-control" id="link" name="link" required="" maxlength="45" value="${menu.link}"/>

                </div>   
                <div class="col-md-4 mb-3 ">
                    <label for="icone">Icone</label>
                    <input type="text" class="form-control" id="icone" name="icone" maxlength="45" value="${menu.icone}"/>

                </div> 
                <div class="col-md-4 mb-3 ">
                    <label for="exibir">Exibir*</label>
                    <select name="exibir" required="" class="form-control">
                        <c:if test="${menu.exibir==null}">
                            <option value="0">Selecine a opção</option>
                            <option value="1">Sim</option>
                            <option value="2">Não</option>
                        </c:if>
                        <c:if test="${menu.exibir==1}">
                            <option value="1" selected="">Sim</option>
                            <option value="2">Não</option>
                        </c:if>
                        <c:if test="${menu.exibir==2}">
                            <option value="1">Sim</option>
                            <option value="2" selected="">Não</option>
                        </c:if>
                    </select>    

                </div>    
                <div class="col-md-4 mb-3">
                    <button class="btn btn-primary">Gravar</button>
                    <a href="listar_menu.jsp" class="btn btn-outline-dark">Voltar</a>    
                </div>    
            </form>   
        </div>
    </body>
</html>
