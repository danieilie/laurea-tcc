<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Cadastrar Usuário</title>
    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        
        <div class="div_formulario">
            
            <form action="gerenciar_usuario.do" method="POST" class="form">
                <div class="form-group ">
                     <h2 class="titulo">Novo Usuário</h2>
                     <div class="campo_obrigatorio">* campos de preenchimento obrigatório</div>
                </div>
                <input type="hidden" name="idusuario" class="form-control" id="idusuario" value="${usuario.idusuario}"/>
                
                   <div class="form-group">
                        <label for="nome">Nome *</label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome Completo" required="" maxlength="45" value="${usuario.nome}" />
                    </div>    
              
                 <div class="form-group">
                        <label for="login">Login *</label>
                        <input type="text" class="form-control" id="login" name="login" placeholder="Para entrar no sistema" required="" maxlength="45" value="${usuario.login}"/>
                    </div>    
               
                <div class="form-group">
                        <label for="senha">Senha *</label>
                        <input type="password" class="form-control" id="senha" name="senha" placeholder="No mínimo 8 caracteres" maxlength="45" required="" value="${usuario.senha}"/>
                        
                    </div>    
            
                <div class="form-group">
                        <label for="status">Status *</label>
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
                
               <div class="form-group">
                        <label for="perfil">Perfil *</label>
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
                   
               <div class="form-group">
                    <button class="btn btn-primary">Gravar</button>
                    <a href="listar_usuario.jsp" class="btn btn-outline-dark">Voltar</a>    
                </div>    
            </form>    
        </div>
    </body>
</html>
