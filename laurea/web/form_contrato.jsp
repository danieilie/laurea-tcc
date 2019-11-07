<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Contrato"%>

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
            <h3>Formulário de Contratação de Serviço</h3>

            <form action="gerenciar_contrato.do" method="POST">
                <input type="hidden" name="idcontrato" id="idcontrato" value="${contrato.idcontrato}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome"> Nome da Escola onde estuda </label>
                        <input type="text" class="form-control" id="nome" name="nome" required="" maxlength="45" value="${contrato.nome}"/>
                    </div>    
                </div>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="disciplina"> Disciplina </label>
                        <select name="iddisciplina" required="" class="form-control">
                            <option value="">Selecine a opção</option>
                            <jsp:useBean class="DAO.DisciplinaDAO" id="dDAO"/>
                            <c:forEach var="d" items="${dDAO.lista}">
                                <option value="${d.iddisciplina}"
                                    <c:if test="${d.iddisciplina==contrato.disciplina.iddisciplina}">
                                        selected=""
                                    </c:if> 
                                >
                                ${d.materia}</option>
                            </c:forEach>
                        </select>    
                    </div>    
                </div>

                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="usuario"> Nome de Usuário </label>
                        <select name="idusuario" required="" class="form-control">
                            <option value="">Selecine a opção</option>
                            <jsp:useBean class="DAO.UsuarioDAO" id="uDAO"/>
                            <c:forEach var="u" items="${uDAO.lista}">
                                <option value="${u.idusuario}"
                                    <c:if test="${u.idusuario==contrato.usuario.idusuario}">
                                        selected=""
                                    </c:if> 
                                >
                                ${u.nome}</option>
                            </c:forEach>
                        </select>    
                    </div>    
                </div>

                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_contrato.jsp" class="btn btn-warning">Voltar</a>    
                </div>    
            </form>  
        </div>
    </body>
</html>
