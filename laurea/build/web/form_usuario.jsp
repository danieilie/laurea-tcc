<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
            <h3>Novo Usuário</h3>

            <form action="gerenciar_usuario.do" method="POST">
                <input type="hidden" name="idusuario" id="idusuario" value="${usuario.idusuario}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" required="" maxlength="45" value="${usuario.nome}"/>
                    </div>    
                </div>    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" id="login" name="login" required="" maxlength="45" value="${usuario.login}"/>
                    </div>    
                </div>   
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control" id="senha" name="senha" maxlength="45" required="" value="${usuario.senha}"/>
                    </div>    
                </div> 
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="status">Status</label>
                        <select name="status" required="" class="form-control">
                            <c:if test="${usuario.status==null}">
                                <option value="">Selecine a opção</option>
                                <option value="1">Ativo</option>
                                <option value="2">Inativo</option>
                            </c:if>
                            <c:if test="${usuario.status==1}">
                                <option value="1" selected="">Ativo</option>
                                <option value="2">Inativo</option>
                            </c:if>
                            <c:if test="${usuario.status==2}">
                                <option value="1">Ativo</option>
                                <option value="2" selected="">Inativo</option>
                            </c:if>
                        </select>    
                    </div>    
                </div>    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="perfil">Perfil</label>
                        <select name="idperfil" required="" class="form-control">
                            <option value="">Selecine a opção</option>
                            <jsp:useBean class="DAO.PerfilDAO" id="pDAO"/>
                            <c:forEach var="p" items="${pDAO.lista}">
                                <option value="${p.idperfil}"
                                        <c:if test="${p.idperfil==usuario.perfil.idperfil}">
                                            selected=""
                                        </c:if> 
                                >
                                    ${p.perfil}</option>
                                </c:forEach>
                        </select>    
                    </div>    
                </div>    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_usuario.jsp" class="btn btn-warning">Voltar</a>    
                </div>    
            </form>    
        </div>
    </body>
</html>
